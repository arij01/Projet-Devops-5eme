import {Component, OnInit} from '@angular/core';
import {Etudiant} from "../etudiant.model";
import {EtudiantService} from "../etudiant.service";

@Component({
  selector: 'app-etudiant-list',
  templateUrl: './etudiant-list.component.html',
  styleUrls: ['./etudiant-list.component.css']
})
export class EtudiantListComponent implements OnInit {
  etudiants: Etudiant[] = [];
  constructor(private etudiantService: EtudiantService) { }

  ngOnInit(): void {
    this.getEtudiants(); // Call the method to fetch etudiants
  }

  getEtudiants(): void {
    this.etudiantService.getEtudiants().subscribe(
      (data: Etudiant[]) => {
        this.etudiants = data; // Assign the fetched etudiants to the class property
      },
      (error) => {
        console.error('Error fetching etudiants', error); // Handle error
      }
    );
  }
}
