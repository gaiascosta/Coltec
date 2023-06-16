using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.EventSystems;

public class ItemRender : MonoBehaviour
{
    public Item item;

    public Text nameText;
    public Text descriptionText;

    public Image artworkImage;

    public Text numberText;
    public Text quantityText;

    void Start()
    {
        nameText.text = item.theName;
        descriptionText.text = item.description;
        artworkImage.sprite = item.artwork;
        numberText.text = item.number.ToString();
        quantityText.text = item.quantity.ToString();
        
    }
    
}
