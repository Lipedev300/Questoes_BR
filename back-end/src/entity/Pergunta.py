from pydantic import BaseModel
from typing import List

class Pergunta(BaseModel):
    id_pergunta: int
    categoria_pergunta: str
    texto_pergunta: str
    alternativas: list[str]
    resposta_correta: str