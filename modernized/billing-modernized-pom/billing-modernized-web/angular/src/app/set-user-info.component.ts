import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserInfoService } from './user-info/user-info.service';

@Component({
    template: '',
    providers: []
})

export class SetUserInfoComponent implements OnInit {
    
    constructor(
        private route: ActivatedRoute,
        private userInfoService: UserInfoService,
        private router: Router
    ) {

    }

    ngOnInit() {
        this.userInfoService.setUserInfo({termId: this.route.snapshot.paramMap.get('termid')})
                .then(() => this.router.navigateByUrl(''));
    }
}
