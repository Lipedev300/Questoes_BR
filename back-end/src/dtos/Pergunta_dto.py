from pydantic import BaseModel
from typing import Optional, List

class Pergunta_create(BaseModel):
    categoria_pergunta: str
    texto_pergunta: str
    alternativas: list[str]
    resposta_correta: str

class pergunta_response(BaseModel):
    id: int
    categoria_pergunta: str
    texto_pergunta: str
    alternativas: list[str]