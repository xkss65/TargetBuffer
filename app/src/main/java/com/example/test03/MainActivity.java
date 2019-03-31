package com.example.test03;

import android.content.res.ColorStateList;
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

import org.fabiomsr.moneytextview.MoneyTextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    int totaal = 0;
    float hulpbedrag1, hulpbedrag2, hulpbedrag3, hulpbedrag4;
    float rekeningSaldo = 60000;
    float totaalTargets = 0;
    int prevSeekbarProgress;

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
        final ImageView ivbuffer = (ImageView) findViewById(R.id.imageView6);
        final ImageView ivbwbuffer = (ImageView) findViewById(R.id.imageView7);
        final TextInputLayout autobedrag = (TextInputLayout) findViewById(R.id.textInputLayoutCar);
        final TextInputLayout huisbedrag = (TextInputLayout) findViewById(R.id.textInputLayoutHuis);
        final TextInputLayout bootbedrag = (TextInputLayout) findViewById(R.id.textInputLayoutBoot);

        final SeekBar sliderAutoHuis = (SeekBar) findViewById(R.id.seekBar);
        final SeekBar sliderAutoBoot = (SeekBar) findViewById(R.id.seekBar4);
        final SeekBar sliderBootHuis = (SeekBar) findViewById(R.id.seekBar2);
        final SeekBar sliderBuffer = (SeekBar) findViewById(R.id.seekBar3);
        final ImageButton deposit = (ImageButton) findViewById(R.id.erbij);
        final ImageButton withdrawal = (ImageButton) findViewById(R.id.eraf);
        final ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) ivbwauto.getLayoutParams();
        final ConstraintLayout.LayoutParams lp2 = (ConstraintLayout.LayoutParams) ivbwhuis.getLayoutParams();
        final ConstraintLayout.LayoutParams lp3 = (ConstraintLayout.LayoutParams) ivbwboot.getLayoutParams();
        final ConstraintLayout.LayoutParams bufferbreedte = (ConstraintLayout.LayoutParams) ivbuffer.getLayoutParams();

        final MoneyTextView targetAuto = (MoneyTextView) findViewById(R.id.targetAuto);
        final MoneyTextView targetHuis = (MoneyTextView) findViewById(R.id.targetHuis);
        final MoneyTextView targetBoot = (MoneyTextView) findViewById(R.id.targetBoot);

        final MoneyTextView autoBedrag = (MoneyTextView) findViewById(R.id.bedragAuto);
        final MoneyTextView huisBedrag = (MoneyTextView) findViewById(R.id.bedragHuis);
        final MoneyTextView bootBedrag = (MoneyTextView) findViewById(R.id.bedragBoot);
        final MoneyTextView bufferBedrag = (MoneyTextView) findViewById(R.id.bedragBuffer);

        lp.height = (50);
        lp2.height = (50);
        lp3.height = (50);
        bufferbreedte.width = (800);
        ivbuffer.bringToFront();
        sliderBuffer.bringToFront();

        ivbwauto.bringToFront();
        ivbwauto.setLayoutParams(lp);
        ivbwhuis.bringToFront();
        ivbwhuis.setLayoutParams(lp2);
        ivbwboot.bringToFront();
        ivbwboot.setLayoutParams(lp3);

        sliderBuffer.setVisibility(View.GONE);
        ivbuffer.setVisibility(View.GONE);
        ivbwbuffer.setVisibility(View.GONE);

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
                }

                hulpbedrag1 = (((autoBedrag.getAmount() + huisBedrag.getAmount()) * (100 - (progress))) / 100);
                hulpbedrag2 = (((autoBedrag.getAmount() + huisBedrag.getAmount()) * progress) / 100);
                autoBedrag.setAmount(hulpbedrag1);
                huisBedrag.setAmount(hulpbedrag2);

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
//                        bootbedrag.setHint(String.valueOf(progress*400));
//                        huisbedrag.setHint(String.valueOf(40000+ (progress*-400)));
                }

                hulpbedrag1 = (((huisBedrag.getAmount() + bootBedrag.getAmount()) * progress) / 100);
                hulpbedrag2 = (((huisBedrag.getAmount() + bootBedrag.getAmount()) * (100 - (progress))) / 100);
                bootBedrag.setAmount(hulpbedrag1);
                huisBedrag.setAmount(hulpbedrag2);

                //                System.out.print("lp2.height: " + lp2.height + "\n");

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
//                    autobedrag.setHint(String.valueOf(40000+ (progress*-400)));
//                    bootbedrag.setHint(String.valueOf(progress*400));
                }

                hulpbedrag1 = (((autoBedrag.getAmount() + bootBedrag.getAmount()) * progress) / 100);
                hulpbedrag2 = (((autoBedrag.getAmount() + bootBedrag.getAmount()) * (100 - (progress))) / 100);
                bootBedrag.setAmount(hulpbedrag1);
                autoBedrag.setAmount(hulpbedrag2);

                //                System.out.print("lp2.height: " + lp2.height + "\n");

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
                sliderBuffer.setVisibility(View.GONE);
                ivbuffer.setVisibility(View.GONE);
                ivbwbuffer.setVisibility(View.GONE);

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
                } else
                    sliderBuffer.setVisibility(View.VISIBLE);
                    ivbuffer.setVisibility(View.VISIBLE);
                    ivbwbuffer.setVisibility(View.VISIBLE);
            }
        });

        ivbwauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sliderBuffer.setVisibility(View.GONE);
                ivbuffer.setVisibility(View.GONE);
                ivbwbuffer.setVisibility(View.GONE);
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
                } else
                    sliderBuffer.setVisibility(View.VISIBLE);
                    ivbuffer.setVisibility(View.VISIBLE);
                    ivbwbuffer.setVisibility(View.VISIBLE);
            }
                });

        ivColHuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sliderBuffer.setVisibility(View.GONE);
                ivbuffer.setVisibility(View.GONE);
                ivbwbuffer.setVisibility(View.GONE);
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
                } else
                    sliderBuffer.setVisibility(View.VISIBLE);
                    ivbuffer.setVisibility(View.VISIBLE);
                    ivbwbuffer.setVisibility(View.VISIBLE);
            }
        });

        ivbwhuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sliderBuffer.setVisibility(View.GONE);
                ivbuffer.setVisibility(View.GONE);
                ivbwbuffer.setVisibility(View.GONE);
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
                } else
                    sliderBuffer.setVisibility(View.VISIBLE);
                    ivbuffer.setVisibility(View.VISIBLE);
                    ivbwbuffer.setVisibility(View.VISIBLE);
            }
        });

        ivColBoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sliderBuffer.setVisibility(View.GONE);
                ivbuffer.setVisibility(View.GONE);
                ivbwbuffer.setVisibility(View.GONE);
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
                } else
                    sliderBuffer.setVisibility(View.VISIBLE);
                    ivbuffer.setVisibility(View.VISIBLE);
                    ivbwbuffer.setVisibility(View.VISIBLE);
            }
        });

        ivbwboot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sliderBuffer.setVisibility(View.GONE);
                ivbuffer.setVisibility(View.GONE);
                ivbwbuffer.setVisibility(View.GONE);
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
                } else
                    sliderBuffer.setVisibility(View.VISIBLE);
                    ivbuffer.setVisibility(View.VISIBLE);
                    ivbwbuffer.setVisibility(View.VISIBLE);
            }
        });


        seekBar=(SeekBar)findViewById(R.id.seekBar3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
 //               lp.height = 1;
                lp2.height = 1;
                lp3.height = 1;
                if (progress == 0) {
                    bufferbreedte.width = 1;
                } else {
                    bufferbreedte.width = ((progress*(100 / seekBar.getMax()))*8);
                }

                if (autobedrag.getVisibility() == View.VISIBLE) {
                    seekBar.setMax(20);
                    if (autoBedrag.getAmount() <= targetAuto.getAmount() && (autoBedrag.getAmount()) >= 0){
                        hulpbedrag1 = (targetAuto.getAmount() - (progress * 1000));
                        autoBedrag.setAmount(hulpbedrag1);
                        if (progress == 0) {
                            lp.height = 1;
                        } else {
                            lp.height = (progress*15);
                        }
                    }
                }

                if (huisbedrag.getVisibility() == View.VISIBLE) {
                    seekBar.setMax(18);
                    if (huisBedrag.getAmount() <= targetHuis.getAmount() && (huisBedrag.getAmount()) >= 0) {
                        hulpbedrag1 = (targetHuis.getAmount() - (progress * 1000));
                        huisBedrag.setAmount(hulpbedrag1);
                        if (progress == 0) {
                            lp2.height = 1;
                        } else {
//                            lp2.height = (progress * (7 / 2));
                            lp2.height = (progress * 20);
                        }
                    }
                }

                if (bootbedrag.getVisibility() == View.VISIBLE) {
                    seekBar.setMax(22);
                    if (bootBedrag.getAmount() <= targetBoot.getAmount() && (bootBedrag.getAmount()) >= 0) {
                        hulpbedrag1 = (targetBoot.getAmount() - (progress * 1000));
                        bootBedrag.setAmount(hulpbedrag1);
                        if (progress == 0) {
                            lp3.height = 1;
                        } else {
                            if (progress == 100) {
                                lp3.height = 165;
                            } else
                                {
                                lp3.height = (progress * 15);
                                }
                        }
                    }
                }
                totaalTargets = (autoBedrag.getAmount() + huisBedrag.getAmount() + bootBedrag.getAmount());
                bufferBedrag.setAmount(rekeningSaldo - totaalTargets);
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
                rekeningSaldo = rekeningSaldo + 1200;
                totaalTargets = (autoBedrag.getAmount() + huisBedrag.getAmount() + bootBedrag.getAmount());
                bufferBedrag.setAmount(rekeningSaldo - totaalTargets);
           }
        });

        withdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (bufferBedrag.getAmount() < 1200) {
                    hulpbedrag3 = (1200 - bufferBedrag.getAmount());
                    hulpbedrag4 = (hulpbedrag3 / 3);
                    if (autoBedrag.getAmount() >= (hulpbedrag4)) {
                        autoBedrag.setAmount(autoBedrag.getAmount() - hulpbedrag4);
                    } else {
                        hulpbedrag4 = (hulpbedrag3 / 2);
                    }

                    if (huisBedrag.getAmount() >= (hulpbedrag4)) {
                        huisBedrag.setAmount(huisBedrag.getAmount() - hulpbedrag4);
                    } else {
                        hulpbedrag4 = hulpbedrag3;
                    }

                    if (bootBedrag.getAmount() >= (hulpbedrag4)) {
                        bootBedrag.setAmount(bootBedrag.getAmount() - hulpbedrag4);
                    } else {
                        Toast.makeText(getApplicationContext(),"Withdrawal unsuccessful!", Toast.LENGTH_LONG).show();
                        rekeningSaldo = rekeningSaldo + hulpbedrag4;
                    }
                }
                rekeningSaldo = rekeningSaldo - 1200;
                totaalTargets = (autoBedrag.getAmount() + huisBedrag.getAmount() + bootBedrag.getAmount());
                bufferBedrag.setAmount(rekeningSaldo - totaalTargets);
            }
        });

    }
//        });
    }

