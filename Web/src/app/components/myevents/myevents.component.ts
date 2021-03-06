import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { EventService } from '../../services/event.service';
import { TokenStorageService } from '../../services/token-storage.service';
import { Event } from '../../models/Event';

@Component({
  selector: 'app-myevents',
  templateUrl: './myevents.component.html',
  styleUrls: ['./myevents.component.css']
})
export class MyeventsComponent implements OnInit {

  eventsJoined: Event[];
  eventsApplied: Event[];
  eventsCreated: Event[];
  id: number;

  constructor(
    private userService: UserService, 
    private eventService: EventService, 
    private tokenStorageService: TokenStorageService,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.tokenStorageService.getUser().user.id;
    this.eventService.getEventsByOrganizer().subscribe(data => this.eventsCreated = data);
    this.userService.getEventsJoined(this.id).subscribe(data => {this.eventsJoined = data});
    this.userService.getEventsApplied().subscribe(data => this.eventsApplied = data);
  }

  cancelRequest(id: number){
    this.eventService.cancelRequest(id).subscribe(() => this.ngOnInit());
  }

  leaveEvent(id: number){
    this.eventService.leaveEvent(id).subscribe(() => this.ngOnInit());
  }

  deleteEvent(id: number){
    this.eventService.deleteEvent(id).subscribe(() => this.ngOnInit());
  }

  getEvent(id: number) {
    this.router.navigateByUrl('/event/' + id);
  }
  
  finishEvent(id: number){
    this.eventService.finishEvent(id).subscribe(() => this.ngOnInit());
  }

  showEvent(id: number){
    this.router.navigateByUrl('/event/' + id);
  }
}
