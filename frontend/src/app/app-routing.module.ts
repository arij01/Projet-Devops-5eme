import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BlocListComponent} from "./bloc-list/bloc-list.component";

const routes: Routes = [
  { path: '', redirectTo: 'retrieve-all-blocs', pathMatch: 'full' }, 
  { path: 'retrieve-all-blocs', component: BlocListComponent },
  // Add other routes here if needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
