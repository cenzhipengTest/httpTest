package cn.itheima.test;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import com.hankcs.lucene.HanLPAnalyzer;

public class QueryIndex {
	
	//查询索引库的所有文件数据
	@Test
	public void queryAllIndex() {
		try {
			Query queryAll  = new MatchAllDocsQuery();
			
			doQuery(queryAll);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryByMultiFiled() {
		try {
			//1.定义关键字作为查询
			String queryStr ="传智播客优秀企业";
			//2.创建解析字符串的对象
			//参数1是解析查询的域字段
			String [] files = new String [] {"fileName","fileContent"};
			MultiFieldQueryParser parser = 
					new MultiFieldQueryParser(files, new HanLPAnalyzer());
			Query query =parser.parse(queryStr);
			doQuery(query);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//通用的查询方法
		private void doQuery(Query queryAll) throws IOException {
			//创建索引的读取对象
			IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get("E:\\luceneIndex")));
			//通过IndexSearcher对象执行查询
			IndexSearcher searcher = new IndexSearcher(reader);
			//读取所有的查询对象创建
			
			//searcher执行query查询数据
			TopDocs topDocs = searcher.search(queryAll,100);
			//topDocs对象是查询结果包含 文档id的数组 和每个文档的得分 
			//totalHits 文档的总命中数量
			System.out.println("文档的总命中数量为：=="+topDocs.totalHits);
			//查询文档id的数组 和每个文档的得分 
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			for(ScoreDoc sd:scoreDocs) {
				System.out.println("当前文档id==="+sd.doc);
				System.out.println("当前文档的得分为==="+sd.score);
				//通过文档的id提取文档的数据
				Document document = searcher.doc(sd.doc);
				System.out.println("文档的name为：==="+document.get("fileName"));
				System.out.println("文档的path为：==="+document.get("filePath"));
				System.out.println("文档的大小为：==="+document.get("fileSize"));
				
			}
		}

}
