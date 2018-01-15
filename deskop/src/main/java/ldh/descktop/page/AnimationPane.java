package ldh.descktop.page;


import ldh.fxanimations.*;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnimationPane extends SplitPane {

    @FXML private Button btn;

    /**
     * Initializes the controller class.
     */
    public AnimationPane() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AnimationPane.class.getResource("/fxml/FXMLAnimationPanel.fxml")); //NOI18N
            loader.setController(this);
            loader.setRoot(this);
            loader.load();

        } catch (IOException ex) {
            Logger.getLogger(AnimationPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML private void flashAction(ActionEvent event)               { new FlashTransition(btn).play(); }
    @FXML private void BounceAction(ActionEvent event)              { new BounceTransition(btn).play(); }
    @FXML private void ShakeAction(ActionEvent event)               { new ShakeTransition(btn).play(); }
    @FXML private void tadaAction(ActionEvent event)                { new TadaTransition(btn).play(); }
    @FXML private void swingAction(ActionEvent event)               { new SwingTransition(btn).play(); }
    @FXML private void wobbleAction(ActionEvent event)              { new WobbleTransition(btn).play(); }
    @FXML private void pulseAction(ActionEvent event)               { new PulseTransition(btn).play(); }
    @FXML private void flipAction(ActionEvent event)                { new FlipTransition(btn).play(); }
    @FXML private void flipInXAction(ActionEvent event)             { new FlipInXTransition(btn).play(); }
    @FXML private void flipInYAction(ActionEvent event)             { new FlipInYTransition(btn).play(); }
    @FXML private void flipOutXAction(ActionEvent event)            { new FlipOutXTransition(btn).play(); bringBackAfter(); }
    @FXML private void flipOutYAction(ActionEvent event)            { new FlipOutYTransition(btn).play(); bringBackAfter(); }
    @FXML private void fadeInAction(ActionEvent event)              { new FadeInTransition(btn).play(); }
    @FXML private void fadeInUpAction(ActionEvent event)            { new FadeInUpTransition(btn).play(); }
    @FXML private void fadeInDownAction(ActionEvent event)          { new FadeInDownTransition(btn).play(); }
    @FXML private void fadeInLeftAction(ActionEvent event)          { new FadeInLeftTransition(btn).play(); }
    @FXML private void fadeInRightAction(ActionEvent event)         { new FadeInRightTransition(btn).play(); }
    @FXML private void fadeInUpBigAction(ActionEvent event)         { new FadeInUpBigTransition(btn).play(); }
    @FXML private void fadeInDownBigAction(ActionEvent event)       { new FadeInDownBigTransition(btn).play(); }
    @FXML private void fadeInLeftBigAction(ActionEvent event)       { new FadeInLeftBigTransition(btn).play(); }
    @FXML private void fadeInRightBigAction(ActionEvent event)      { new FadeInRightBigTransition(btn).play(); }
    @FXML private void fadeOutAction(ActionEvent event)             { new FadeOutTransition(btn).play(); bringBackAfter(); }
    @FXML private void fadeOutUpAction(ActionEvent event)           { new FadeOutUpTransition(btn).play(); bringBackAfter(); }
    @FXML private void fadeOutDownAction(ActionEvent event)         { new FadeOutDownTransition(btn).play(); bringBackAfter(); }
    @FXML private void fadeOutLeftAction(ActionEvent event)         { new FadeOutLeftTransition(btn).play(); bringBackAfter(); }
    @FXML private void fadeOutRightAction(ActionEvent event)        { new FadeOutRightTransition(btn).play(); bringBackAfter(); }
    @FXML private void fadeOutUpBigAction(ActionEvent event)        { new FadeOutUpBigTransition(btn).play(); bringBackAfter(); }
    @FXML private void fadeOutDownBigAction(ActionEvent event)      { new FadeOutDownBigTransition(btn).play(); bringBackAfter(); }
    @FXML private void fadeOutLeftBigAction(ActionEvent event)      { new FadeOutLeftBigTransition(btn).play(); bringBackAfter(); }
    @FXML private void fadeOutRightBigAction(ActionEvent event)     { new FadeOutRightBigTransition(btn).play(); bringBackAfter(); }
    @FXML private void bounceInAction(ActionEvent event)            { new BounceInTransition(btn).play(); }
    @FXML private void bounceInUpAction(ActionEvent event)          { new BounceInUpTransition(btn).play(); }
    @FXML private void bounceInDownAction(ActionEvent event)        { new BounceInDownTransition(btn).play(); }
    @FXML private void bounceInLeftAction(ActionEvent event)        { new BounceInLeftTransition(btn).play(); }
    @FXML private void bounceInRightAction(ActionEvent event)       { new BounceInRightTransition(btn).play(); }
    @FXML private void bounceOutAction(ActionEvent event)           { new BounceOutTransition(btn).play(); bringBackAfter(); }
    @FXML private void bounceOutUpAction(ActionEvent event)         { new BounceOutUpTransition(btn).play(); bringBackAfter(); }
    @FXML private void bounceOutDownAction(ActionEvent event)       { new BounceOutDownTransition(btn).play(); bringBackAfter(); }
    @FXML private void bounceOutLeftAction(ActionEvent event)       { new BounceOutLeftTransition(btn).play(); bringBackAfter(); }
    @FXML private void bounceOutRightAction(ActionEvent event)      { new BounceOutRightTransition(btn).play(); bringBackAfter(); }
    @FXML private void rotateAction(ActionEvent event)              { new RotateInTransition(btn).play(); }
    @FXML private void rotateInDownLeftAction(ActionEvent event)    { new RotateInDownLeftTransition(btn).play(); }
    @FXML private void rotateInDownRightAction(ActionEvent event)   { new RotateInDownRightTransition(btn).play(); }
    @FXML private void rotateInUpLeftAction(ActionEvent event)      { new RotateInUpLeftTransition(btn).play(); }
    @FXML private void rotateInUpRightAction(ActionEvent event)     { new RotateInUpRightTransition(btn).play(); }
    @FXML private void rotateOutAction(ActionEvent event)           { new RotateOutTransition(btn).play(); bringBackAfter(); }
    @FXML private void rotateOutDownLeftAction(ActionEvent event)   { new RotateOutDownLeftTransition(btn).play(); bringBackAfter(); }
    @FXML private void rotateOutDownRightAction(ActionEvent event)  { new RotateOutDownRightTransition(btn).play(); bringBackAfter(); }
    @FXML private void rotateOutUpLeftAction(ActionEvent event)     { new RotateOutUpLeftTransition(btn).play(); bringBackAfter(); }
    @FXML private void rotateOutUpRightAction(ActionEvent event)    { new RotateOutUpRightTransition(btn).play(); bringBackAfter(); }
    @FXML private void hingeAction(ActionEvent event)               { new HingeTransition(btn).play(); bringBackAfter(); }
    @FXML private void rollInAction(ActionEvent event)              { new RollInTransition(btn).play(); }
    @FXML private void rollOutAction(ActionEvent event)             { new RollOutTransition(btn).play(); bringBackAfter(); }

    private void bringBackAfter() {
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(1.5));
        pauseTransition.play();
        pauseTransition.setOnFinished((ActionEvent t) -> { btn.setOpacity(1); btn.autosize(); });
    }
}
