package m2j9702.test.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 두 번째 액티비티
 */
public class SecondActivity extends AppCompatActivity implements View.OnClickListener
{
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		Intent intent = getIntent();
		String data = intent.getStringExtra("문자열");

		Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

		Button btnOk = (Button) findViewById(R.id.btn_ok);
		Button btnCancel = (Button) findViewById(R.id.btn_cancel);

		btnOk.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		// 눌린 버튼이 확인 버튼일 때
		if (v.getId() == R.id.btn_ok)
		{
			EditText editNumber = (EditText) findViewById(R.id.edit_number);

			Intent i = new Intent();
			i.putExtra("asdf", Integer.parseInt(editNumber.getText().toString()));
			setResult(RESULT_OK, i);
		}

		// 눌린 버튼이 취소 버튼일 때
		else if (v.getId() == R.id.btn_cancel)
		{
			setResult(RESULT_CANCELED);
		}

		finish();
	}

	/**
	 * 두 수의 최대공약수를 구하는 함수
	 * @param a 첫 번째 수
	 * @param b 두 번째 수
	 * @return 두 수의 최대공약수
	 */
	public int getGCD(int a, int b)
	{
		if (b == 0)
			return a;
		return getGCD(b, a % b);
	}
}