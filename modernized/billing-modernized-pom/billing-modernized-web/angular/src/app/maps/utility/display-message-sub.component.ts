import { Component } from '@angular/core';
import { Window } from "../commonMap/window";
import { LanguageService } from '../../language/language-service';
import { TermState } from '../../models/term-state.model';

@Component({
    selector: 'display-message',
    standalone: false,
    templateUrl: './display-message.component.html'
})
export class DisplayMessageSubComponent extends Window {    
    systemName: any = {};
    messageQueue: any = {};
    program: any = {};
    library: any = {};
    programLib: any = {};

    severity: any = {};
    delivery: any = {};
    from: any = {};
    date: any = {};
    time: any = {};
    message: any = [];
    isResponseEmpty : boolean = false;
    isBreakMessage: any = {};
    
    public FIELDS: string[] = ['systemName', 'messageQueue', 'program', 'library', 'programLib', 'severity', 'delivery', 'message', 'from', 'date', 'time', 'isBreakMessage'];

    getClass(extendedValue: number, normalValue: number): string {
        const value = this.termState.isExtended ? extendedValue : normalValue;
        return value.toString().padStart(2, '0');
    }

    constructor(public languageService: LanguageService, public termState: TermState) {
        super();
    }

    ngOnInit() {
        if (!Array.isArray(this.message)) {
            this.message = [];
        }
    }
}
