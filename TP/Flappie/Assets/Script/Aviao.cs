using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Aviao : MonoBehaviour {
    [SerializeField]private float forca = 9;
    Rigidbody2D fisica;
    private Diretor diretor;

    private void Awake()
    {
        this.fisica = this.GetComponent<Rigidbody2D>();
        this.diretor = GameObject.FindObjectOfType<Diretor>();
    }

    private void Update () { 
        if(Input.GetButtonDown("Fire1") || Input.GetKeyDown("space"))
        {
            this.Impulsionar();
        }
    }

    private void Impulsionar()
    {
        this.fisica.AddForce(Vector2.up * forca, ForceMode2D.Impulse);
    }

    private void OnCollisionEnter2D(Collision2D colisao)
    {
        this.fisica.simulated = false;
        this.diretor.FinalizarJogo();
    }
}