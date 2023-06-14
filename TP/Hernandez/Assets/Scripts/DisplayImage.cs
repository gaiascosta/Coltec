using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DisplayImage : MonoBehaviour
{
    [SerializeField] private int currentWall;
    private SpriteRenderer sprite;

    private void Start() {
        sprite = GetComponent<SpriteRenderer>();
    }

    public void changeWall(bool dir){

        if (dir) currentWall++;
        else currentWall--;

        if (currentWall > 4) currentWall = 1;
        else if (currentWall < 1) currentWall = 4;
        sprite.sprite = Resources.Load<Sprite>("Sprites/wall" + currentWall.ToString());
    }
}
