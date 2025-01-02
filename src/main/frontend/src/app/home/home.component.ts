import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { AsyncPipe, JsonPipe } from '@angular/common';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  imports: [JsonPipe, AsyncPipe],
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  currentUser$: any;
  serverInfo$!: Observable<any>;

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {
    this.currentUser$ = this.authService.currentUser;
  }

  logout(): void {
    this.authService.logout().subscribe({
      next: () => {
        alert('Logout successful');
        this.router.navigateByUrl('/login');
      },
    });
  }

  getServerInfo() {
    this.serverInfo$ = this.authService.serverInfo();
  }

}
