package app.example.siddharthbyale.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import java.util.HashMap;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.iid.FirebaseInstanceId;

public class FragmentDoubt extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frament_doubt,container,false);

        Button mSubmitDoubt=rootView.findViewById(R.id.submitDoubt);
        final EditText doubt = rootView.findViewById(R.id.doubt);
        mSubmitDoubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dId= FirebaseDatabase.getInstance().getReference().child("Doubt").push().getKey();
                HashMap<String,Object>map = new HashMap<>();
                map.put("id","test");
                map.put("timestamp", ServerValue.TIMESTAMP);
                map.put("text",doubt.getText().toString());
                map.put("solved",false);
                FirebaseDatabase.getInstance().getReference().child("Doubts").child(dId).setValue(map);
                doubt.setText("");
                doubt.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });

        return rootView;

    }

}
