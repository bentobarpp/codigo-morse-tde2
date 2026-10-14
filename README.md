# Código Morse - Árvore Binária de Busca (TDE 2)

Projeto da disciplina Resolução de Problemas Estruturados em Computação (PUCPR).

Implementa o alfabeto Morse como uma Árvore Binária de Busca: a partir da raiz, cada
**ponto (.)** desce para a **esquerda** e cada **traço (-)** desce para a **direita**.
Ao final do caminho de uma letra, o nó guarda o caractere correspondente.

## Estrutura

- `MorseNode.java` — nó da árvore (símbolo, letra opcional, filho esquerdo/direito).
- `MorseAlphabet.java` — tabela com o código Morse padrão (A-Z, 0-9).
- `MorseTree.java` — árvore: inserção pela heurística do Morse, decodificação e impressão.
- `MorseSoundPlayer.java` — bônus: reproduz o código Morse em som (ponto = beep curto, traço = beep longo).
- `Main.java` — menu de console que integra tudo.

## Como compilar e rodar

```bash
cd src
javac *.java
java Main
```

## Funcionalidades (menu)

1. Mostrar a árvore binária de busca resultante (console).
2. Decodificar uma palavra em Morse digitada pelo usuário (ex: `.... . .-.. .-.. ---`).
3. Codificar uma palavra em texto para Morse.
4. (Bônus) Tocar o código Morse digitado em som.

## Autoria

Desenvolvido por Bento de Oliveira Barp.
