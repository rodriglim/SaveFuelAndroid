package com.example.savefuel;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;

public class AnimationClass implements AnimationMethod{
    private boolean button, text;
    private TextView textView;
    private ImageButton imageButton;

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

    private void animationClass(){
        Animation animation = new AlphaAnimation(0,1);
        animation.setDuration(1);
        animation.setRepeatMode(1);
        animation.setInterpolator(new LinearInterpolator());
        if(text){
            textView.startAnimation(animation);
        }
        if(button){
            imageButton.startAnimation(animation);
        }
    }
    @Override
    public void btnAnimationTxtView(TextView textView) {
        text = true;
        this.setTextView(textView);
        animationClass();
    }

    @Override
    public void btnAnimationImageButton(ImageButton imageButton) {
        button = true;
        this.setImageButton(imageButton);
        animationClass();
    }

}
