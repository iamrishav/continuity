package com.example.continuity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class KeyboardFragment extends Fragment implements View.OnTouchListener, View.OnClickListener, TextWatcher {

    private EditText typeHereEditText;
    private Button ctrlButton, altButton, shiftButton, enterButton, tabButton, escButton, printScrButton, backspaceButton;
    private Button deleteButton, clearTextButton;
    private Button nButton, tButton, wButton, rButton, fButton, zButton;
    private Button cButton, xButton, vButton, aButton, oButton, sButton;
    private Button ctrlAltTButton, ctrlShiftZButton, altF4Button;
    private String previousText = "";

    public KeyboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_keyboard, container, false);
        initialization(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getResources().getString(R.string.keyboard));
    }

    private void initialization(View rootView) {
        typeHereEditText = (EditText) rootView.findViewById(R.id.typeHereEditText);
        ctrlButton = (Button) rootView.findViewById(R.id.ctrlButton);
        altButton = (Button) rootView.findViewById(R.id.altButton);
        shiftButton = (Button) rootView.findViewById(R.id.shiftButton);
        enterButton = (Button) rootView.findViewById(R.id.enterButton);
        tabButton = (Button) rootView.findViewById(R.id.tabButton);
        escButton = (Button) rootView.findViewById(R.id.escButton);
        printScrButton = (Button) rootView.findViewById(R.id.printScrButton);
        backspaceButton = (Button) rootView.findViewById(R.id.backspaceButton);
        deleteButton = (Button) rootView.findViewById(R.id.deleteButton);
        clearTextButton = (Button) rootView.findViewById(R.id.clearTextButton);
        nButton = (Button) rootView.findViewById(R.id.nButton);
        tButton = (Button) rootView.findViewById(R.id.tButton);
        wButton = (Button) rootView.findViewById(R.id.wButton);
        rButton = (Button) rootView.findViewById(R.id.rButton);
        fButton = (Button) rootView.findViewById(R.id.fButton);
        zButton = (Button) rootView.findViewById(R.id.zButton);
        cButton = (Button) rootView.findViewById(R.id.cButton);
        xButton = (Button) rootView.findViewById(R.id.xButton);
        vButton = (Button) rootView.findViewById(R.id.vButton);
        aButton = (Button) rootView.findViewById(R.id.aButton);
        oButton = (Button) rootView.findViewById(R.id.oButton);
        sButton = (Button) rootView.findViewById(R.id.sButton);
        ctrlAltTButton = (Button) rootView.findViewById(R.id.ctrlAltTButton);
        ctrlShiftZButton = (Button) rootView.findViewById(R.id.ctrlShiftZButton);
        altF4Button = (Button) rootView.findViewById(R.id.altF4Button);
        ctrlButton.setOnTouchListener(this);
        altButton.setOnTouchListener(this);
        shiftButton.setOnTouchListener(this);
        backspaceButton.setOnClickListener(this);
        enterButton.setOnClickListener(this);
        tabButton.setOnClickListener(this);
        escButton.setOnClickListener(this);
        printScrButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        clearTextButton.setOnClickListener(this);
        nButton.setOnClickListener(this);
        tButton.setOnClickListener(this);
        wButton.setOnClickListener(this);
        rButton.setOnClickListener(this);
        fButton.setOnClickListener(this);
        zButton.setOnClickListener(this);
        cButton.setOnClickListener(this);
        xButton.setOnClickListener(this);
        vButton.setOnClickListener(this);
        aButton.setOnClickListener(this);
        oButton.setOnClickListener(this);
        sButton.setOnClickListener(this);
        ctrlAltTButton.setOnClickListener(this);
        ctrlShiftZButton.setOnClickListener(this);
        altF4Button.setOnClickListener(this);
        typeHereEditText.addTextChangedListener(this);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        String action = "KEY_PRESS";
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            action = "KEY_PRESS";
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            action = "KEY_RELEASE";
        }
        int keyCode = 17;//dummy initialization
        switch (v.getId()) {
            case R.id.ctrlButton:
                keyCode = 17;
                break;
            case R.id.altButton:
                keyCode = 18;
                break;
            case R.id.shiftButton:
                keyCode = 16;
                break;
        }
        sendKeyCodeToServer(action, keyCode);
        return false;
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.clearTextButton) {
            typeHereEditText.setText("");
        } else if (id == R.id.ctrlAltTButton || id == R.id.ctrlShiftZButton || id == R.id.altF4Button) {
            String message = "CTRL_SHIFT_Z";
            switch (id) {
                case R.id.ctrlAltTButton:
                    message = "CTRL_ALT_T";
                    break;
                case R.id.ctrlShiftZButton:
                    message = "CTRL_SHIFT_Z";
                    break;
                case R.id.altF4Button:
                    message = "ALT_F4";
                    break;
            }
            MainActivity.sendMessageToServer(message);
        } else {
            int keyCode = 17;//dummy initialization
            String action = "TYPE_KEY";
            switch (id) {
                case R.id.enterButton:
                    keyCode = 10;
                    break;
                case R.id.tabButton:
                    keyCode = 9;
                    break;
                case R.id.escButton:
                    keyCode = 27;
                    break;
                case R.id.printScrButton:
                    keyCode = 154;
                    break;
                case R.id.deleteButton:
                    keyCode = 127;
                    break;
                case R.id.nButton:
                    keyCode = 78;
                    break;
                case R.id.tButton:
                    keyCode = 84;
                    break;
                case R.id.wButton:
                    keyCode = 87;
                    break;
                case R.id.rButton:
                    keyCode = 82;
                    break;
                case R.id.fButton:
                    keyCode = 70;
                    break;
                case R.id.zButton:
                    keyCode = 90;
                    break;
                case R.id.cButton:
                    keyCode = 67;
                    break;
                case R.id.xButton:
                    keyCode = 88;
                    break;
                case R.id.vButton:
                    keyCode = 86;
                    break;
                case R.id.aButton:
                    keyCode = 65;
                    break;
                case R.id.oButton:
                    keyCode = 79;
                    break;
                case R.id.sButton:
                    keyCode = 83;
                    break;
                case R.id.backspaceButton:
                    keyCode = 8;
                    break;
            }
            sendKeyCodeToServer(action, keyCode);
        }

    }
    private void sendKeyCodeToServer(String action, int keyCode) {
        MainActivity.sendMessageToServer(action);
        MainActivity.sendMessageToServer(keyCode);
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        char ch = newCharacter(s, previousText);
        if (ch == 0) {
            return;
        }
        MainActivity.sendMessageToServer("TYPE_CHARACTER");
        MainActivity.sendMessageToServer(Character.toString(ch));
        previousText = s.toString();
    }
    @Override
    public void afterTextChanged(Editable s) {
    }

    private char newCharacter(CharSequence currentText, CharSequence previousText) {
        char ch = 0;
        int currentTextLength = currentText.length();
        int previousTextLength = previousText.length();
        int difference = currentTextLength - previousTextLength;
        if (currentTextLength > previousTextLength) {
            if (1 == difference) {
                ch = currentText.charAt(previousTextLength);
            }
        } else if (currentTextLength < previousTextLength) {
            if (-1 == difference) {
                ch = '\b';
            } else {
                ch = ' ';
            }
        }
        return ch;
    }

}

/**
 * ctrl: 17
 * alt: 18
 * shift: 16
 * enter: 10
 * tab: 9
 * esc: 27
 * prntScr: 154
 * backspace: 524
 * delete: 127
 * backspace: 8
 */
/**
 * N: 78
 * T: 84
 * W: 87
 * R: 82
 * F: 70
 * Z: 90
 * C: 67
 * X: 88
 * V: 86
 * A: 65
 * O: 79
 * S: 83

 */
