package com.example.billing.program.utils;

import com.netfective.bluage.gapwalk.logging.BluageWrapperException;
import com.netfective.bluage.gapwalk.logging.codes.GeneralErrorCodes;
import com.netfective.bluage.gapwalk.rt.jics.bms.MapRegistry;
import com.netfective.bluage.gapwalk.terminal.MapException;
import com.netfective.bluage.gapwalk.terminal.TerminalMap;
import com.netfective.bluage.gapwalk.terminal.TerminalMapLoader;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/** Load JSON representations of BMS maps (as extracted by Analyzer) */
@Component
public class MapLoader {

	/**
	 * The Constant logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MapLoader.class);


	@Autowired
	private ApplicationContext applicationContext;

	/** Search for /maps/*.json files */
	@PostConstruct
	public void registerMaps() {

		if (!applicationContext.getResource("classpath:/maps/").exists()) {
			LOGGER.info("No maps folder; nothing to load");
			return;
		}

		TerminalMapLoader loader = new TerminalMapLoader();
		try {
			for (Resource resource : applicationContext.getResources("classpath:/maps/*.json")) {
				loadMap(loader, resource);
			}
		} catch (IOException e){
			throw new BluageWrapperException(e, GeneralErrorCodes.A5000);
		}
	}

	private void loadMap(TerminalMapLoader loader, Resource resource) throws IOException {
		try (InputStream is = resource.getInputStream()) {

			// Read and parse resource
			String data = IOUtils.toString(is,StandardCharsets.UTF_8);
			TerminalMap mapset = loader.parse(data);

			// Add to registry
			MapRegistry.register(mapset, resource);

		} catch (MapException e) {
			// Do not halt loader
			LOGGER.error("Error while loading map " + resource.getFilename(), e);
		}
	}

	/**
	 * Unregister all maps previously added.
	 */
	@PreDestroy
	public void unregisterMaps() {
		// No cleanup required
	}
}

