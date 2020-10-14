import { Component, OnInit } from '@angular/core';
import{ EventService } from '../../services/event.service';
import { Event } from '../../models/Event'
@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.css']
})
export class EventFormComponent implements OnInit {

  sport : string;
  address : string;
  startDate : string;
  maxParticipants : number;
  price : number;
  comments:string;

  constructor(public eventService : EventService) { }

  ngOnInit(): void {
  }

  createEvent(){
      let e = new Event(this.sport, this.address, this.startDate, this.maxParticipants, this.price, this.comments);
      console.log(e);
      this.eventService.createEvent(e).subscribe((res:Response) => {
        console.log(res);
      });
  }

}
