from pydantic import BaseModel

class Partida(BaseModel):
    idPartida: int
    id_jogador: int
    pontuacao: int
    vidas: int = 3