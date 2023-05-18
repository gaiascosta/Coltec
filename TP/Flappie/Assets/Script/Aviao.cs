using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Aviao : MonoBehaviour {
    [SerializeField]private float forca = 9;
    Rigidbody2D fisica;

    private void Awake()
    {
        this.fisica = this.GetComponent<Rigidbody2D>();
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
}