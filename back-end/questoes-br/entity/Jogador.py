from pydantic import BaseModel

class Jogador(BaseModel):
    id: int
    apelido: str
    pontuacao_maxima: int = 0