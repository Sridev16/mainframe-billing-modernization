import { Component, Input, AfterContentChecked } from '@angular/core';
import { Overlay } from '../commonMap/overlay';
import { TermState } from '../../models/term-state.model';

@Component({
    selector: 'display-message-msg',
    standalone: false,
    templateUrl: './display-message-msg.component.html'
})
export class DisplayMessageMsgComponent extends Overlay implements AfterContentChecked {
    @Input() message: any;
    @Input() index: number;

    msgLine: any = {};

    public FIELDS: string[] = ['msgLine'];

    constructor(public termState: TermState) {
        super();
    }

    ngAfterContentChecked(): void {
        this.msgLine = this.message.msgLine;
    }
}