using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GerarObstaculo : MonoBehaviour
{
    [SerializeField]private float tempoParaGerar;
    [SerializeField]private float tempoParaDestruir;
    [SerializeField] private GameObject manualDeInstrucoes;
    private float cronometro;
    private void Awake()
    {
        this.cronometro = this.tempoParaGerar;
    }
    void Update () {
    //Quando que eu quero gerar? Tempo
    this.cronometro -= Time.deltaTime;
    if(this.cronometro < 0)
        {
            var position = new Vector2(11, Random.Range(-1.4f, 1.4f));
            GameObject gameObj = GameObject.Instantiate(this.manualDeInstrucoes, position, Quaternion.identity);
            this.cronometro = this.tempoParaGerar;
            Destroy(gameObj, tempoParaDestruir);
        }
    }
}
