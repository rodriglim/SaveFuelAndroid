import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;


public class AnimationBtn implements AnimationMethod{
    private boolean callText, callButton;
    private TextView textView;
    private ImageButton imageButton;

    private void animation(){
        Animation animation = new AlphaAnimation(0,1);
        animation.setRepeatMode(1);
        animation.setDuration(1);
        animation.setInterpolator(new LinearInterpolator());
        if(callText){
            textView.startAnimation(animation);
        }else{
            imageButton.startAnimation(animation);
        }
    }

    @Override
    public void btnAnimationTxtView(TextView textView) {
        this.setTextView(textView);
        animation();
    }

    @Override
    public void btnAnimationImageButton(ImageButton imageButton) {
        this.setImageButton(imageButton);
        animation();
    }

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
}
