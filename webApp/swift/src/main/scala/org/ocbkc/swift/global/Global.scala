package org.ocbkc.swift.global
{  
//import org.ocbkc.swift.model._
//import System._
//import org.ocbkc.swift.cores.{TraitGameCore, NotUna}
//import org.ocbkc.swift.cores.gameCoreHelperTypes._
/* Conventions:
- Names of classes correspond with design $JN/...
- CTL = Computationally Transparent Language
- NL  = Natural Language
*/
import org.eclipse.jgit.api._
import org.eclipse.jgit.lib._
import org.eclipse.jgit.storage.file._
import java.io._

object GlobalConstant
{  val TEST = true
   val NEWLINE = System.getProperty("line.separator")
   val WEBAPROOT = "/home/waimondrio/jowneeGitProjects/SWiFTfososc/source/webApp/swift" // CHANGE TO YOUR MACHINE
   val ABSOLUTEPATHS = true // set true when you want all paths in this dir to be absolute, sometimes handy when you want to execute parts of the application from another directory. Default should be false.
   
   private val PREFIX = if( ABSOLUTEPATHS ) WEBAPROOT + "/" else ""
   val CONSTITUTIONHTMLDIR = PREFIX + "src/main/webapp/constitutions/"
   val PERSISTDIR = PREFIX + "persist" // directory to hold all data required for making app persistent (= survive shutdown and starts)
   val CONSTITUTIONOBJECTDIR = PERSISTDIR + "/constobjs"
   val SWIFTURL = "http://127.0.0.1:8080"
   /*
   val jgitRepo = new Repository(new File(new File(CONSTITUTIONHTMLDIR)))

   jgitRepo.create()
   jgitRepo.getConfig().setBoolean("core", null, "bare", false)
   */
   
   val jgitBuilder:FileRepositoryBuilder = new FileRepositoryBuilder()
   val jgitRepo:Repository = jgitBuilder.setGitDir(new File(CONSTITUTIONHTMLDIR + "/.git"))
      //.readEnvironment() // scan environment GIT_* variables
      //.findGitDir() // scan up the file system tree <&y2012.06.30.19:51:12& perhaps leave this one out, it SHOULD be in this dir, not in a superdir>
      .build()
   println("   jgitRepo directory: " + jgitRepo.getDirectory() )
   println("   jgitRepo is bare (false is correct): " + jgitRepo.isBare())
   

   val jgit = new Git(jgitRepo) // <? &y2012.06.30.18:53:23& or isn't this thread safe? I now share one jgit object accross user-sessions (I think... because I instantiate this thing in Boot.scala). Perhaps I should instantiate one per user-session...>
   println(jgit.status().call().getUntracked)
}

object TestSettings
{  val AUTOLOGIN = true
   val AUTOTRANSLATION = false
}

}
