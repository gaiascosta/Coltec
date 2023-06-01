using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;

public class Pontuacao : MonoBehaviour {
    private int pontos;
    [SerializeField] private Text textoPontuacao;
    private AudioSource audioPontuacao;

    private void Awake(){
        this.audioPontuacao = this.GetComponent<AudioSource>();
    }

    public void AdicionarPontos()
    {
        this.pontos++;
        this.textoPontuacao.text = this.pontos.ToString();
        this.audioPontuacao.Play();
    } 

    public void Reiniciar(){
        this.pontos = 0;
        this.textoPontuacao.text = this.pontos.ToString();
    }

}
