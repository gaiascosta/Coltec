using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraController : MonoBehaviour
{
    //para colocarmos nosso personagem como alvo
    public Transform target; 
    //para suavizar o efeito da câmera
    public float smoothing; 
    
    public Vector2 minPosition;
    public Vector2 maxPosition;
    
    void Start(){
        
    }

    
    void LateUpdate(){
        //vamos fazer a câmera seguir o personagem em x e y, mas manter o seu z.
        //transform.position = new Vector3(target.transform.position.x,target.transform.position.y, transform.position.z);

        if (transform.position != target.position){

            Vector3 targetPosition = new Vector3(target.transform.position.x,target.transform.position.y, transform.position.z);

            //clamp in between
            targetPosition.x = Mathf.Clamp(targetPosition.x, minPosition.x, maxPosition.x);
            targetPosition.y = Mathf.Clamp(targetPosition.y, minPosition.y, maxPosition.y);

            //gradualmente move o objeto: posição original, posição alvo, velocidade
            transform.position = Vector3.Lerp(transform.position, targetPosition, smoothing);
        }

    }
}
