export class Bloc {
  idBloc: number;       // `number` type matches with `long` from Java
  nomBloc: string;      // `string` type for text
  capaciteBloc: number; // `number` type for another `long` equivalent

  constructor(idBloc: number, nomBloc: string, capaciteBloc: number) {
    this.idBloc = idBloc;
    this.nomBloc = nomBloc;
    this.capaciteBloc = capaciteBloc;
  }
}
