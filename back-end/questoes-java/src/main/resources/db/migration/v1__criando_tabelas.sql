-- criando tabela jogador
CREATE TABLE Jogador (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    apelido VARCHAR(30),
    pontuacao_maxima INT DEFAULT 0 NOT NULL
);

-- criando tabela partida
CREATE TABLE Partida (
    id_partida INTEGER PRIMARY KEY AUTOINCREMENT,
    id_jogador INT NOT NULL,
    pontuacao INT DEFAULT 0,
    vidas INT DEFAULT 0,
    CONSTRAINT fk_jogador
        FOREIGN KEY (id_jogador) 
        REFERENCES Jogador(id)
        ON DELETE CASCADE
);

--criando tabela pergunta
CREATE TABLE Pergunta (
    id INTEGER PRIMARY KEY AUTOINCREMENT, 
    categoria_pergunta VARCHAR(30) NOT NULL,
    texto_pergunta TEXT UNIQUE NOT NULL,
    alternativas TEXT NOT NULL, -- Para armazenar a lista de alternativas (ex: como string JSON)
    resposta_correta VARCHAR(10) NOT NULL
);

-- criando tabela intermediária partida_pergunta para relacionamentos
CREATE TABLE PartidaPergunta (
    id INTEGER,
    id_partida INT NOT NULL,
    id_pergunta INT NOT NULL,
    respondida_corretamente BOOLEAN NOT NULL,
    PRIMARY KEY (id_partida, id_pergunta),
    
    CONSTRAINT fk_partida
        FOREIGN KEY (id_partida) 
        REFERENCES Partida(id_partida)
        ON DELETE CASCADE,      
    CONSTRAINT fk_pergunta
        FOREIGN KEY (id_pergunta) 
        REFERENCES Pergunta(id)
        ON DELETE CASCADE
);