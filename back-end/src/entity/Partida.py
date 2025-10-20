from pydantic import BaseModel

class Partida(BaseModel):
    idPartida: int
    id_jogador: int
    quantidade_perguntas: int
    pontuacao: int
    vidas: int = 3