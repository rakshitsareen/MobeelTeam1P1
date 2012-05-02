//sg
package TCSMobeel.Prototypes.One;



import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MobeelPrototypeOneActivity extends Activity {
    /** Called when the activity is first created. */
    String executionOutput;
    Integer points;
    Button flip,execute;
    EditText fly1,fly2,fly3,fly4,textS1,textS2,initLoop,loopInc,loopLimit;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        OnClickListener uponDone=new ExecuteInput();
        //Get The references
        fly1=(EditText)findViewById(R.id.editTextFly1);
       
        fly2=(EditText)findViewById(R.id.editTextFly2);
        fly3=(EditText)findViewById(R.id.editTextFly3);
        fly4=(EditText)findViewById(R.id.editTextFly4);
        textS1=(EditText)findViewById(R.id.editTextS1);
        textS2=(EditText)findViewById(R.id.editTextS5);
        initLoop=(EditText)findViewById(R.id.editTextInitCount);
       loopInc=(EditText)findViewById(R.id.editTextIncrement);
        loopLimit=(EditText)findViewById(R.id.editTextLimit);
        execute=(Button)findViewById(R.id.buttonDone);
        execute.setOnClickListener(uponDone);
        flip=(Button)findViewById(R.id.buttonFlip1);
        flip.setOnClickListener(new Flipper());
	}
	class  Flipper implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			final Dialog d = new Dialog(MobeelPrototypeOneActivity.this);
			Window w = d.getWindow();
			w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
			w.setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
					WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
			d.setTitle("CodePlay");
			d.setContentView(R.layout.level1layout);
			Button flip = (Button) d.findViewById(R.id.buttonFlip);
			
			
			flip.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					d.dismiss();
				}
			});
			d.show();
		}
			
		}
		

	class ExecuteInput implements OnClickListener  //TODO: This should be a separate class,not an inner class
	{

		Integer s1,s2,lini,linc,ll,f1,f2,f3,f4;
		@Override
		public void onClick(View v) {
			getValues();
			verifySolution();
			displayResult();
		}
	
		void getValues()
		{
			s1=Integer.parseInt(textS1.getText().toString());
	
			lini=Integer.parseInt(initLoop.getText().toString());
			linc=Integer.parseInt(loopInc.getText().toString());
			ll=Integer.parseInt(loopLimit.getText().toString());
			s2=Integer.parseInt(textS2.getText().toString());
			f1=Integer.parseInt(fly1.getText().toString());
			f2=Integer.parseInt(fly2.getText().toString());
			f3=Integer.parseInt(fly3.getText().toString());
			f4=Integer.parseInt(fly4.getText().toString());
		}
		boolean verifySolution()
		{
			points=0;
			//TODO : executionOutput should be made String Buffer
			executionOutput="";
			executionOutput+="Codee Moved "+s1.toString()+"steps forward\n";
			//TODO append failure reasons to the if clauses
			if(s1!=5)
			{
				return false;
			}
			points+=4;
			executionOutput+="After a good start,he got prepared to jump\n";
			if(lini!=1)
			{
				return false;
			}
			points+=4;
			executionOutput+="After a smooth first jump,he increased his power by "+linc.toString()+"\n";
			if(linc!=2)
			{
				return false;
			}
			points+=4;
			executionOutput+="Then he kept on jumping till the power became"+ll.toString()+"\n";
			if(ll!=5)
			{
				return false;
			}
			points+=4;
			executionOutput+="he then moved "+s2.toString()+"steps forward\n";
			if(s2!=7)
			{
				return false;
			}
			points+=4;
			executionOutput+="The difficult times stared at him as he reached the \"Alternate Valley\"";
			if((f1!=3)||(f2!=5)||(f3!=5)||(f4!=7))
			{
				return false;  
			}
			executionOutput+="\n Codee Managed To Strike the right balance of 3-5-5-7\n";
			points+=24;
			executionOutput+="\nAnd he finally reached to the other end safely!!";
			
			return true;
			
		}
		void displayResult()
		{
			executionOutput+="\nYour Score : "+points.toString();
			final Dialog d = new Dialog(MobeelPrototypeOneActivity.this);
			Window w = d.getWindow();
			w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
			w.setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
					WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
			d.setTitle("CodePlay");
			d.setContentView(R.layout.result);
			Button ok = (Button) d.findViewById(R.id.buttonOk);
			TextView res = (TextView) d.findViewById(R.id.textViewResult);
			res.setText(executionOutput);
			
			ok.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					d.dismiss();
				}
			});
			d.show();
		}
		
	}
    
}