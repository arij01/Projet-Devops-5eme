// etudiant.model.ts
export class Etudiant {
  idEtudiant!: number;         // The ! operator denotes that this will be initialized
  nomEtudiant!: string;
  prenomEtudiant!: string;
  cinEtudiant!: number;
  dateNaissance!: Date;

  constructor(
    idEtudiant: number,
    nomEtudiant: string,
    prenomEtudiant: string,
    cinEtudiant: number,
    dateNaissance: Date
  ) {
    this.idEtudiant = idEtudiant;
    this.nomEtudiant = nomEtudiant;
    this.prenomEtudiant = prenomEtudiant;
    this.cinEtudiant = cinEtudiant;
    this.dateNaissance = dateNaissance;
  }
}
