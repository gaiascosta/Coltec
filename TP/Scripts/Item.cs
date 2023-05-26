using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[CreateAssetMenu(fileName = "New Item", menuName = "Item")]
public class Item : ScriptableObject
{
    public string theName;
    public string description;
    public int number;
    public int quantity;
    public Sprite artwork;
}
