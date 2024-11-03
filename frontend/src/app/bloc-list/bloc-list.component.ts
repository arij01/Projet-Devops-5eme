import {Component, OnInit} from '@angular/core';
import {Bloc} from "../bloc.model";
import {BlocService} from "../bloc.service";

@Component({
  selector: 'app-bloc-list',
  templateUrl: './bloc-list.component.html',
  styleUrls: ['./bloc-list.component.css']
})
export class BlocListComponent implements OnInit {
  blocs: Bloc[] = [];
  constructor(private blocService: BlocService) { }

  ngOnInit(): void {
    this.getBlocs(); // Call the method to fetch blocs
  }

  getBlocs(): void {
    this.blocService.getBlocs().subscribe(
      (data: Bloc[]) => {
        this.blocs = data; // Assign the fetched etudiants to the class property
      },
      (error) => {
        console.error('Error fetching blocs', error); // Handle error
      }
    );
  }
}
