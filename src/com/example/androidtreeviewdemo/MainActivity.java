package com.example.androidtreeviewdemo;

import java.util.ArrayList;

import com.example.androidtreeviewdemo.treeview.Element;
import com.example.androidtreeviewdemo.treeview.TreeViewAdapter;
import com.example.androidtreeviewdemo.treeview.TreeViewItemClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	/** 树中的元素集合 */
	private ArrayList<Element> elements;
	/** 数据源元素集合 */
	private ArrayList<Element> elementsData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		init();
		
		ListView treeview = (ListView) findViewById(R.id.treeview);
		TreeViewAdapter treeViewAdapter = new TreeViewAdapter(
				elements, elementsData, inflater);
		TreeViewItemClickListener treeViewItemClickListener = new TreeViewItemClickListener(treeViewAdapter);
		treeview.setAdapter(treeViewAdapter);
		treeview.setOnItemClickListener(treeViewItemClickListener);
	}
	
	private void init() {
		elements = new ArrayList<Element>();
		elementsData = new ArrayList<Element>();
		
		//添加节点  -- 节点名称，节点level，节点id，父节点id，是否有子节点，是否展开
		
		//添加最外层节点
		Element e1 = new Element("山东省", Element.TOP_LEVEL, 0, Element.NO_PARENT, true, false);
		
		//添加第一层节点
		Element e2 = new Element("青岛市", Element.TOP_LEVEL + 1, 1, e1.getId(), true, false);
		//添加第二层节点
		Element e3 = new Element("市南区", Element.TOP_LEVEL + 2, 2, e2.getId(), true, false);
		//添加第三层节点
		Element e4 = new Element("香港中路", Element.TOP_LEVEL + 3, 3, e3.getId(), false, false);
		
		//添加第一层节点
		Element e5 = new Element("烟台市", Element.TOP_LEVEL + 1, 4, e1.getId(), true, false);
		//添加第二层节点
		Element e6 = new Element("芝罘区", Element.TOP_LEVEL + 2, 5, e5.getId(), true, false);
		//添加第三层节点
		Element e7 = new Element("凤凰台街道", Element.TOP_LEVEL + 3, 6, e6.getId(), false, false);
		
		//添加第一层节点
		Element e8 = new Element("威海市", Element.TOP_LEVEL + 1, 7, e1.getId(), false, false);
		
		//添加最外层节点
		Element e9 = new Element("广东省", Element.TOP_LEVEL, 8, Element.NO_PARENT, true, false);
		//添加第一层节点
		Element e10 = new Element("深圳市", Element.TOP_LEVEL + 1, 9, e9.getId(), true, false);
		//添加第二层节点
		Element e11 = new Element("南山区", Element.TOP_LEVEL + 2, 10, e10.getId(), true, false);
		//添加第三层节点
		Element e12 = new Element("深南大道", Element.TOP_LEVEL + 3, 11, e11.getId(), true, false);
		//添加第四层节点
		Element e13 = new Element("10000号", Element.TOP_LEVEL + 4, 12, e12.getId(), false, false);
		
		//添加初始树元素
		elements.add(e1);
		elements.add(e9);
		//创建数据源
		elementsData.add(e1);
		elementsData.add(e2);
		elementsData.add(e3);
		elementsData.add(e4);
		elementsData.add(e5);
		elementsData.add(e6);
		elementsData.add(e7);
		elementsData.add(e8);
		elementsData.add(e9);
		elementsData.add(e10);
		elementsData.add(e11);
		elementsData.add(e12);
		elementsData.add(e13);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
