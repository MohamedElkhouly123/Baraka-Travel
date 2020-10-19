package com.example.barakatravelapp.view.activity;

import android.os.Bundle;
import android.widget.Toast;
import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.fragment.HomeCycle2.accounts.ChangeDetailsFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.accounts.ChangeDetailsMoreFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.accounts.GetEVisaFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.accounts.MyUmrahBookingFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.accounts.PaymentsFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.discover.ConfirmBookingFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.discover.SelectPaymentMethodFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.discover.SuccessfulPaymentFragment;
import com.example.barakatravelapp.view.fragment.userCycle.SignUpFragment;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class UserCycleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cycle);
        replaceFragment(getSupportFragmentManager(), R.id.user_activity_fram, new ConfirmBookingFragment());

//        Toast.makeText(this, "here", Toast.LENGTH_LONG)
//                .show();

    }

}
