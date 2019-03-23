package com.example.test03;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    int totaal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView ivColHuis = (ImageView) findViewById(R.id.imageView4);
        final ImageView ivbwhuis = (ImageView) findViewById(R.id.imageView5);
        final ImageView ivColAuto = (ImageView) findViewById(R.id.imageView);
        final ImageView ivbwauto = (ImageView) findViewById(R.id.imageView2);
        final ImageView ivColBoot = (ImageView) findViewById(R.id.imageView3);
        final ImageView ivbwboot = (ImageView) findViewById(R.id.imageView8);
        final TextInputLayout autobedrag = (TextInputLayout) findViewById(R.id.textInputLayoutCar);
        final TextInputLayout huisbedrag = (TextInputLayout) findViewById(R.id.textInputLayoutHuis);
        final TextInputLayout bootbedrag = (TextInputLayout) findViewById(R.id.textInputLayoutBoot);

        final SeekBar sliderAutoHuis = (SeekBar) findViewById(R.id.seekBar);
        final SeekBar sliderAutoBoot = (SeekBar) findViewById(R.id.seekBar4);
        final SeekBar sliderBootHuis = (SeekBar) findViewById(R.id.seekBar2);
        final SeekBar sliderBuffer = (SeekBar) findViewById(R.id.seekBar3);
        final ImageButton deposit = (ImageButton) findViewById(R.id.imageButton);
        final ImageButton withdrawal = (ImageButton) findViewById(R.id.imageButton2);
        final TextInputEditText bufferbedrag = (TextInputEditText) findViewById(R.id.textInputEditTextBuffer);
        final ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) ivbwauto.getLayoutParams();
        final ConstraintLayout.LayoutParams lp2 = (ConstraintLayout.LayoutParams) ivbwhuis.getLayoutParams();
        final ConstraintLayout.LayoutParams lp3 = (ConstraintLayout.LayoutParams) ivbwboot.getLayoutParams();

        lp.height = (50);
        lp2.height = (50);
        lp3.height = (50);

        ivbwauto.bringToFront();
        ivbwauto.setLayoutParams(lp);
        ivbwhuis.bringToFront();
        ivbwhuis.setLayoutParams(lp2);
        ivbwboot.bringToFront();
        ivbwboot.setLayoutParams(lp3);

        seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                if (progress == 0) {
                    lp.height = 1;
                    lp2.height = 344;
                } else {
                    lp.height = (progress*3);
                    lp2.height = (344-(progress*(7/2)));
                    autobedrag.setHint(String.valueOf(40000+ (progress*-400)));
                    huisbedrag.setHint(String.valueOf(progress*400));
                }

                ivbwauto.bringToFront();
                ivbwauto.setLayoutParams(lp);
                ivbwhuis.bringToFront();
                ivbwhuis.setLayoutParams(lp2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

    seekBar=(SeekBar)findViewById(R.id.seekBar2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
//                Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();

                if (progress == 0) {
                    lp2.height = 1;
                    lp3.height = 369;
                } else

                    if (progress > 98) {
                        lp3.height = 1;
                    } else {

                        lp2.height = (progress*(7/2));
                        lp3.height = (369 - (progress*3));
                        bootbedrag.setHint(String.valueOf(progress*400));
                        huisbedrag.setHint(String.valueOf(40000+ (progress*-400)));
                }
                System.out.print("lp2.height: " + lp2.height + "\n");

                ivbwhuis.bringToFront();
                ivbwhuis.setLayoutParams(lp2);
                ivbwboot.bringToFront();
                ivbwboot.setLayoutParams(lp3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        seekBar=(SeekBar)findViewById(R.id.seekBar4);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
//                Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();

//                ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) ivbwauto.getLayoutParams();

                if (progress == 0) {
                    lp.height = 1;
                    lp3.height = 369;
                } else

                if (progress > 98) {
                    lp3.height = 1;
                } else {
                    lp.height = (progress*3);
                    lp3.height = (369 - (progress*3));
                    autobedrag.setHint(String.valueOf(40000+ (progress*-400)));
                    bootbedrag.setHint(String.valueOf(progress*400));
                }
                System.out.print("lp2.height: " + lp2.height + "\n");

                ivbwauto.bringToFront();
                ivbwauto.setLayoutParams(lp);
                ivbwboot.bringToFront();
                ivbwboot.setLayoutParams(lp3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        ivColAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (autobedrag.getVisibility() == View.VISIBLE) {
                    huisbedrag.setVisibility(View.GONE);
                    bootbedrag.setVisibility(View.GONE);
                    sliderAutoHuis.setVisibility(View.GONE);
                    sliderAutoBoot.setVisibility(View.GONE);
                    sliderBootHuis.setVisibility(View.GONE);
                } else
                    autobedrag.setVisibility(View.VISIBLE);

                if (huisbedrag.getVisibility() == View.VISIBLE) {
                    if(bootbedrag.getVisibility() == View.VISIBLE) {
//                        autobedrag.setVisibility(View.GONE);
                        huisbedrag.setVisibility(View.GONE);
                        bootbedrag.setVisibility(View.GONE);
                        sliderAutoHuis.setVisibility(View.GONE);
                        sliderAutoBoot.setVisibility(View.GONE);
                        sliderBootHuis.setVisibility(View.GONE);
                    } else
                        sliderAutoHuis.setVisibility(View.VISIBLE);
                } else
                if (bootbedrag.getVisibility() == View.VISIBLE) {
                    sliderAutoBoot.setVisibility(View.VISIBLE);
                }
            }
        });

        ivbwauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (autobedrag.getVisibility() == View.VISIBLE) {
                    huisbedrag.setVisibility(View.GONE);
                    bootbedrag.setVisibility(View.GONE);
                    sliderAutoHuis.setVisibility(View.GONE);
                    sliderAutoBoot.setVisibility(View.GONE);
                    sliderBootHuis.setVisibility(View.GONE);
                } else
                    autobedrag.setVisibility(View.VISIBLE);

                if (huisbedrag.getVisibility() == View.VISIBLE) {
                    if(bootbedrag.getVisibility() == View.VISIBLE) {
//                        autobedrag.setVisibility(View.GONE);
                        huisbedrag.setVisibility(View.GONE);
                        bootbedrag.setVisibility(View.GONE);
                        sliderAutoHuis.setVisibility(View.GONE);
                        sliderAutoBoot.setVisibility(View.GONE);
                        sliderBootHuis.setVisibility(View.GONE);
                    } else
                        sliderAutoHuis.setVisibility(View.VISIBLE);
                } else
                if (bootbedrag.getVisibility() == View.VISIBLE) {
                    sliderAutoBoot.setVisibility(View.VISIBLE);
                }
            }
                });

        ivColHuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (huisbedrag.getVisibility() == View.VISIBLE) {
                    autobedrag.setVisibility(View.GONE);
                    bootbedrag.setVisibility(View.GONE);
                    sliderAutoHuis.setVisibility(View.GONE);
                    sliderAutoBoot.setVisibility(View.GONE);
                    sliderBootHuis.setVisibility(View.GONE);
                } else
                    huisbedrag.setVisibility(View.VISIBLE);

                if (autobedrag.getVisibility() == View.VISIBLE) {
                    if(bootbedrag.getVisibility() == View.VISIBLE) {
                        autobedrag.setVisibility(View.GONE);
//                        huisbedrag.setVisibility(View.GONE);
                        bootbedrag.setVisibility(View.GONE);
                        sliderAutoHuis.setVisibility(View.GONE);
                        sliderAutoBoot.setVisibility(View.GONE);
                        sliderBootHuis.setVisibility(View.GONE);
                    } else
                        sliderAutoHuis.setVisibility(View.VISIBLE);
                } else
                if (bootbedrag.getVisibility() == View.VISIBLE) {
                    sliderBootHuis.setVisibility(View.VISIBLE);
                }
            }
        });

        ivbwhuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (huisbedrag.getVisibility() == View.VISIBLE) {
                    autobedrag.setVisibility(View.GONE);
                    bootbedrag.setVisibility(View.GONE);
                    sliderAutoHuis.setVisibility(View.GONE);
                    sliderAutoBoot.setVisibility(View.GONE);
                    sliderBootHuis.setVisibility(View.GONE);
                } else
                    huisbedrag.setVisibility(View.VISIBLE);

                if (autobedrag.getVisibility() == View.VISIBLE) {
                    if(bootbedrag.getVisibility() == View.VISIBLE) {
                        autobedrag.setVisibility(View.GONE);
//                        huisbedrag.setVisibility(View.GONE);
                        bootbedrag.setVisibility(View.GONE);
                        sliderAutoHuis.setVisibility(View.GONE);
                        sliderAutoBoot.setVisibility(View.GONE);
                        sliderBootHuis.setVisibility(View.GONE);
                    } else
                        sliderAutoHuis.setVisibility(View.VISIBLE);
                } else
                if (bootbedrag.getVisibility() == View.VISIBLE) {
                    sliderBootHuis.setVisibility(View.VISIBLE);
                }
            }
        });

        ivColBoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bootbedrag.getVisibility() == View.VISIBLE) {
                    huisbedrag.setVisibility(View.GONE);
                    autobedrag.setVisibility(View.GONE);
                    sliderAutoHuis.setVisibility(View.GONE);
                    sliderAutoBoot.setVisibility(View.GONE);
                    sliderBootHuis.setVisibility(View.GONE);
                } else
                    bootbedrag.setVisibility(View.VISIBLE);

                if (huisbedrag.getVisibility() == View.VISIBLE) {
                    if(autobedrag.getVisibility() == View.VISIBLE) {
                        autobedrag.setVisibility(View.GONE);
                        huisbedrag.setVisibility(View.GONE);
//                        bootbedrag.setVisibility(View.GONE);
                        sliderAutoHuis.setVisibility(View.GONE);
                        sliderAutoBoot.setVisibility(View.GONE);
                        sliderBootHuis.setVisibility(View.GONE);
                    } else
                        sliderBootHuis.setVisibility(View.VISIBLE);
                } else
                if (autobedrag.getVisibility() == View.VISIBLE) {
                    sliderAutoBoot.setVisibility(View.VISIBLE);
                }
            }
        });

        ivbwboot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bootbedrag.getVisibility() == View.VISIBLE) {
                    huisbedrag.setVisibility(View.GONE);
                    autobedrag.setVisibility(View.GONE);
                    sliderAutoHuis.setVisibility(View.GONE);
                    sliderAutoBoot.setVisibility(View.GONE);
                    sliderBootHuis.setVisibility(View.GONE);
                } else
                    bootbedrag.setVisibility(View.VISIBLE);

                if (huisbedrag.getVisibility() == View.VISIBLE) {
                    if(autobedrag.getVisibility() == View.VISIBLE) {
                        autobedrag.setVisibility(View.GONE);
                        huisbedrag.setVisibility(View.GONE);
//                        bootbedrag.setVisibility(View.GONE);
                        sliderAutoHuis.setVisibility(View.GONE);
                        sliderAutoBoot.setVisibility(View.GONE);
                        sliderBootHuis.setVisibility(View.GONE);
                    } else
                        sliderBootHuis.setVisibility(View.VISIBLE);
                } else
                if (autobedrag.getVisibility() == View.VISIBLE) {
                    sliderAutoBoot.setVisibility(View.VISIBLE);
                }
            }
        });

//        sliderBuffer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                autobedrag.setVisibility(View.GONE);
//                huisbedrag.setVisibility(View.GONE);
//                bootbedrag.setVisibility(View.GONE);
//                sliderAutoHuis.setVisibility(View.GONE);
//                sliderAutoBoot.setVisibility(View.GONE);
//                sliderBootHuis.setVisibility(View.GONE);
//            }
//        });


        seekBar=(SeekBar)findViewById(R.id.seekBar3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                lp.height = 1;
                lp2.height = 1;
                lp3.height = 1;

                if (autobedrag.getVisibility() == View.VISIBLE) {
                    autobedrag.setHint(String.valueOf(40000 + (progress * -400)));
 //                   totaal = (totaal - (40000 + (progress * -400)));
 //                   bufferbedrag.setHint(String.valueOf(totaal));
                    bufferbedrag.setHint(String.valueOf(progress * 600));
                }

                if (huisbedrag.getVisibility() == View.VISIBLE) {
                    huisbedrag.setHint(String.valueOf(40000 + (progress * -400)));
//                    totaal = (totaal - (40000 + (progress * -400)));
//                    bufferbedrag.setHint(String.valueOf(totaal));
                    bufferbedrag.setHint(String.valueOf(progress * 600));
                }

                if (bootbedrag.getVisibility() == View.VISIBLE) {
                    bootbedrag.setHint(String.valueOf(40000 + (progress * -400)));
//                    totaal = (totaal - (40000 + (progress * -400)));
//                    bufferbedrag.setHint(String.valueOf(totaal));
                    bufferbedrag.setHint(String.valueOf(progress * 600));
                }

//                if (progress == 0) {
//                    lp.height = 1;
//                    lp3.height = 369;
//                } else

//                if (progress > 98) {
//                    lp3.height = 1;
//                } else {
//                    lp.height = (progress*3);
//                    lp3.height = (369 - (progress*3));
//                    autobedrag.setHint(String.valueOf(40000+ (progress*-400)));
//                    bootbedrag.setHint(String.valueOf(progress*400));
//                }
//                System.out.print("lp2.height: " + lp2.height + "\n");

//                ivbwauto.bringToFront();
//                ivbwauto.setLayoutParams(lp);
//                ivbwboot.bringToFront();
//                ivbwboot.setLayoutParams(lp3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });




        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bufferbedrag.setHint(String.valueOf(60600));
            }
        });

        withdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bufferbedrag.setHint(String.valueOf(59400));;
            }
        });

    }
//        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

//        return super.onOptionsItemSelected(item);
//    }
//}
