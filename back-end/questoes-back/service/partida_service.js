import partida from "../entity/Partida"
import pergunta from "../entity/pergunta"

const iniciarPartida = function(partida) {
    console.log(`Partida iniciada! Id da partida: ${partida.id}`);
    return partida.id;
}