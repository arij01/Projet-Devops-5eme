import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EtudiantListComponent} from "./etudiant-list/etudiant-list.component";

const routes: Routes = [
  { path: '', redirectTo: 'retrieve-all-etudiants', pathMatch: 'full' }, // Redirect to etudiant-list
  { path: 'retrieve-all-etudiants', component: EtudiantListComponent },
  // Add other routes here if needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
