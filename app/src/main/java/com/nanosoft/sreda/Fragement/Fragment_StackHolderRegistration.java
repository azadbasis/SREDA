package com.nanosoft.sreda.Fragement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.nanosoft.sreda.R;


/**
 * Created by User on 7/20/2016.
 */
public class Fragment_StackHolderRegistration extends Fragment {
    Context con;
    public EditText editText;
    private EditText etFullName,etEmail,etAddress,etDescription,etPhone,etMobile;
    private Button btnRegister;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.stack_holder_registration, container, false);
        editText = (EditText)view. findViewById(R.id.etPassworda);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       // initialize(view);
    }

    private void initialize(View view) {




      /*  etFullName = (EditText)view.findViewById(R.id.etFullName);
        etEmail = (EditText)view.findViewById(R.id.etEmail);
        etAddress = (EditText)view.findViewById(R.id.etAddress);
        etDescription = (EditText)view.findViewById(R.id.etDescription);
        etPhone = (EditText)view.findViewById(R.id.etPhone);
        etMobile = (EditText)view.findViewById(R.id.etMobile);
        btnRegister = (Button)view.findViewById(R.id.btnRegister);
*/

    }
}
