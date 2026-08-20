import { Component } from '@angular/core';

@Component({
    selector: 'display-message',
    standalone: false,
    template: '<modal-window class="modal-window" name="display-message"></modal-window>'
})
export class DisplayMessageComponent {
    messageQueue: any = {};
    program: any = {};
    library: any = {};
    programLib: any = {};
    severity: any = {};
    delivery: any = {};
    message: any = {};

    public FIELDS: string[] = ['systemName', 'messageQueue', 'program', 'library', 'programLib', 'severity', 'delivery', 'message'];
}
