package cs296JTalk;

import java.util.Vector;

public class JChatSession {
	public Vector<JPacket> History;
	public Vector<String> name;
	public JChatSession()
	{
		History=new Vector<JPacket>();
		name=new Vector<String>();
	}
	public void printLog()
	{
		for(int i=0;i<History.size();i++)
		{
			System.out.print(name.elementAt(i)+" ");
			History.elementAt(i).print();
		}
	}
}
