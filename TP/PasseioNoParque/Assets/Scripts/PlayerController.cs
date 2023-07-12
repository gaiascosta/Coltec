using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour{
    private Rigidbody2D player;
    private Animator myAnimation;
    [SerializeField] private float speed;

    void Start(){
        player = GetComponent<Rigidbody2D>();
        myAnimation = GetComponent<Animator>();
    }
    void Update(){
        player.velocity = new Vector2(Input.GetAxisRaw("Horizontal"), Input.GetAxisRaw("Vertical")) * speed ;

        myAnimation.SetFloat("moveX", player.velocity.x);
        myAnimation.SetFloat("moveY", player.velocity.y);

        //Se estivermos para a direção X, nosso último movimento será para X
        if (Input.GetAxisRaw("Horizontal") == 1 || Input.GetAxisRaw("Horizontal") == -1 ||
            Input.GetAxisRaw("Vertical") == 1 || Input.GetAxisRaw("Vertical") == -1){
            myAnimation.SetFloat("lastMoveX", Input.GetAxisRaw("Horizontal")); 
            myAnimation.SetFloat("lastMoveY", Input.GetAxisRaw("Vertical")); 
        }
    }
}
