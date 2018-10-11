export class Regras{
    constructor(
        public nomeRegras? : string,
        public descricaoRegras?: string,
        public nomeParEntrada?: string,
        public tipoParEntrada?: string,
        public mandatorio?: boolean,
        public nomeParSaida?: string,
        public tipoParSaida?: string,
    ){}
}