import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;



public class WordCount {
	public static void main(String[] args) throws Exception{
		BufferedReader bf=new BufferedReader(new FileReader("wj.txt"));
		String s;
		String[] a;//���ͳ�Ƶĵ��ʵ�Ƶ��
		Map<String,Integer> map=new TreeMap<String,Integer>();//�����ü�ֵ�Եķ�ʽ��ȡ����
		while((s=bf.readLine())!=null){
			String[] words=s.split("[^a-zA-Z]");//��ȡ��ĸ���������ļ��룬������ַ���
			for(int i=0;i<words.length;i++){
				String key=words[i].toLowerCase();//���ڹ�������ĸ��Сд
				if(key.length()>0){
					if(!map.containsKey(key)){
						map.put(key,1);
					}else{
						int value=map.get(key);
						value++;
						map.put(key,value);
					}
				}
			}			
		}
		//ʹ��switch���ʵ�ֹ���ѡ��
		System.out.println("-------��Ƶ--------");
		System.out.println("1.�������ʵĲ���");
		System.out.println("2.��Ƶ�ʵ���ʾ");
		System.out.println("3.����ļ����");
		Scanner input = new Scanner(System.in);
		int i=input.nextInt();	
		switch(i){
		case 1:
			//��ʾ�û����뵥�ʣ�����ʾ��ʲô���Ÿ���
			System.out.printf("��������Ҫ���ҵĵ��ʣ�����';'����");
			String str= input.next();
			Tongji tj=new Tongji();
			a=tj.oneword(map,str); //ͨ������������ʵ�ֵ������ʵ�Ƶ��
			break;					//��break�ж�ѭ��������һֱִ�У�ֱ�����
		case 2:		
			Scanner sc=new Scanner(System.in);
		    System.out.println("������Ҫ�鿴�ĸ�Ƶ��Ƶ�ĸ���:"); 
			int k = sc.nextInt();  
			Tongji tj1=new Tongji();
			tj1.gaopin(map, k);	//ͨ������������ʵ�ֵ������ʵ�Ƶ��
			break;
		case 3:
			Tongji tj2=new Tongji();
			tj2.out(map);	//ͨ����������������result�ļ�
			break;
		}	
	}
}