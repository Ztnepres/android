package com.example.android.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener, implements TopSectionFragment.TopSectionListener{
    @Override
    public void createMeme(String top, String bottom) {
        BottomPictureFragment bottomFragment = (BottomPictureFragment) getSupportFragmentManager().findFragmentById((R.id.fragment2));
        bottomFragment.setMemeText(top,bottom);
    }

    private TextView gestureMessage;
    private GestureDetectorCompat gestureDetector;

    //alt insert methods will add skeleton to implementations
    //////////////////////      BEGIN GESTURES         ////////////////////////////
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        gestureMessage.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        gestureMessage.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        gestureMessage.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        gestureMessage.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        gestureMessage.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        gestureMessage.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        gestureMessage.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        gestureMessage.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        gestureMessage.setText("onFling");
        return true;
    }
   ////////////////////////////      END GESTURES   //////////////////////////////

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        gestureMessage = (TextView)findViewById(R.id.gestureMessage);
//        this.gestureDetector = new GestureDetectorCompat(this,this); //object to detect gestures
//        gestureDetector.setOnDoubleTapListener(this);

        Button myButton = (Button)findViewById(R.id.myButton);
        myButton.setOnClickListener(
            new Button.OnClickListener(){
                public void onClick(View v){
                    TextView myText = (TextView)findViewById(R.id.myText);
                    myText.setText("Good Job");
                }
            }
        );

        myButton.setOnLongClickListener(
            new Button.OnLongClickListener(){
                public boolean onLongClick(View v){
                    TextView myText = (TextView)findViewById(R.id.myText);
                    myText.setText("Goooooood Job");
                    return true;
                }
            }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
