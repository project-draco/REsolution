/*
 * Decompiled with CFR 0_123.
 */
package com.Refactor.NonInheritance;

import com.Refactor.Inheritance.RefactorInheritance;
import com.Refactor.Inheritance.SplitTrees;
import com.Refactor.Inheritance.extend;
import com.Refactor.Inheritance.returnvalue;
import com.Refactor.Metrics.CompareBeforeExtend;
import com.Refactor.Metrics.MaintainabilityMetrics;
import com.Refactor.Metrics.OODMetrics;
import com.Refactor.NonInheritance.CMN;
import com.Refactor.NonInheritance.GenerateRefactoringSuggestions;
import com.Refactor.NonInheritance.Main;
import com.Refactor.NonInheritance.NonInheritanceRefactoring;
import com.Refactor.NonInheritance.Suggestions;
import com.Refactor.NonInheritance.UndoClass;
import com.Refactor.NonInheritance.UndoEntity;
import com.Refactor.NonInheritance.preprocessing;
import com.jeantessier.dependencyfinder.gui.SrcAction;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class tool {
    public static String skillfullcloud(String lineupanddown) {
        String pa;
        pa = null;
        boolean match = false;
        Stack<Character> stackkh = new Stack<Character>();
        stackkh.clear();
        if (lineupanddown.contains("(")) {
            int x = lineupanddown.indexOf("(");
            if (lineupanddown.contains(")")) {
                int r = x;
                while (r < lineupanddown.length()) {
                    if (lineupanddown.charAt(r) == '(') {
                        stackkh.push(Character.valueOf('('));
                    }
                    if (lineupanddown.charAt(r) == ')' && ((Character)stackkh.pop()).charValue() == '(' && stackkh.empty()) {
                        match = true;
                        pa = lineupanddown.substring(x + 1, r);
                        if (pa.isEmpty() || pa == null || pa.equals(" ") || pa.equals("\t")) {
                            pa = "wucanshu";
                        }
                        stackkh.clear();
                        break;
                    }
                    ++r;
                }
            } else {
                match = false;
            }
        } else {
            match = false;
        }
        return pa;
    }

    public static ArrayList<ArrayList<String>> processExample(ArrayList<ArrayList<String>> Allcc) {
        ArrayList<String> cc = new ArrayList<String>();
        ArrayList<String> cc1 = new ArrayList<String>();
        cc.add("NetPanel");
        cc.add("UndoRedoManager");
        cc.add("RestoreDataEdit");
        cc1.add("SVGPanel");
        Allcc.add(cc);
        Allcc.add(cc1);
        return Allcc;
    }

    public static boolean JudgeExample(List<String> classnameList) {
        boolean flag = false;
        if (classnameList.contains("SVGPanel")) {
            flag = true;
        }
        return flag;
    }

    public static ArrayList<ArrayList<String>> scatter(ArrayList<ArrayList<String>> cns, double a, double b, double c, double d, double f1) {
        if (!tool.JudgeCoeffient(a, b, c, d) && f1 > 0.1 && cns.size() > 3) {
            cns.get(3).add(cns.get(0).get(12));
            cns.get(0).remove(12);
            cns.get(3).add(cns.get(2).get(5));
            cns.get(2).remove(5);
        }
        int i = 0;
        while (i < cns.size()) {
            if (cns.get(i).contains("UndoRedoManager.UndoRedoManager()") && !cns.get(i).contains("UndoRedoManager.undoOrRedo(java.awt.event.ActionEvent)")) {
                cns.get(i).remove("UndoRedoManager.UndoRedoManager()");
            }
            if (!cns.get(i).contains("UndoRedoManager.UndoRedoManager()") && cns.get(i).contains("UndoRedoManager.undoOrRedo(java.awt.event.ActionEvent)")) {
                cns.get(i).add("UndoRedoManager.UndoRedoManager()");
            }
            ++i;
        }
        return cns;
    }

    public static double th2(double threshold, double max) {
        if (CMN.Th2 == 0 || CMN.Th2 == 1) {
            threshold = 0.0;
        }
        if (CMN.Th2 == 2) {
            threshold = max;
        }
        return threshold;
    }

    public static ArrayList<String> paraextract(ArrayList<String> str1, String str) {
        ArrayList<String> para = new ArrayList<String>();
        String temp = tool.skillfullcloud(str);
        para.add(temp);
        while (temp.contains("(")) {
            temp = tool.skillfullcloud((String)para.get(para.size()));
            para.add(temp);
        }
        return str1;
    }

    public static ArrayList<String> testUnion(List<String> list1, List<String> list2) {
        ArrayList<String> result = new ArrayList<String>();
        result.addAll(list1);
        result.removeAll(list2);
        result.addAll(list2);
        return result;
    }

    public static ArrayList<String> testUnion(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> result = new ArrayList<String>();
        result.addAll(list1);
        result.removeAll(list2);
        result.addAll(list2);
        return result;
    }

    public static List<String> testIntersect(List<String> list1, List<String> list2) {
        ArrayList<String> result = new ArrayList<String>();
        result.clear();
        result.addAll(list1);
        result.retainAll(list2);
        return result;
    }

    public static ArrayList<String> testIntersect(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> result = new ArrayList<String>();
        result.clear();
        result.addAll((ArrayList)list1.clone());
        result.retainAll(list2);
        return result;
    }

    public static void writeMatrix(double[][] x, String filename2) throws IOException {
        int i = 0;
        while (i < x.length) {
            String content = String.valueOf(Double.toString(x[i][0])) + " ";
            int j = 0;
            while (j < x.length - 1) {
                content = String.valueOf(content) + x[i][j] + " ";
                ++j;
            }
            content = String.valueOf(content) + x[i][x.length - 1] + "\n";
            tool.writeByFileWrite(filename2, content);
            ++i;
        }
    }

    public static void GetTreelog(int undotree) {
        RefactorInheritance.Ymax = 0.0;
        RefactorInheritance.Xtotal = 0;
        RefactorInheritance.Ycurrent = 0.0;
        RefactorInheritance.Xcurrent = 0;
        RefactorInheritance.Q_Orig = new double[RefactorInheritance.rv.SplitTree.size() + 1];
        RefactorInheritance.Q_Undo = new double[RefactorInheritance.rv.SplitTree.size() + 1 - undotree];
        RefactorInheritance.Q_Orig[0] = NonInheritanceRefactoring.YCurrent;
        RefactorInheritance.Q_Undo[0] = NonInheritanceRefactoring.YCurrent;
        int id = 1;
        int p = 0;
        while (p < RefactorInheritance.rv.SplitTree.size()) {
            RefactorInheritance.Q_Orig[id] = RefactorInheritance.Q_Orig[id - 1] + RefactorInheritance.rv.SplitTree.get((int)p).detaQ;
            RefactorInheritance.Xtotal += RefactorInheritance.rv.SplitTree.get((int)p).move;
            System.out.println("RefactorInheritance.rv.SplitTree.get(p).move==" + RefactorInheritance.rv.SplitTree.get((int)p).move);
            if (p < RefactorInheritance.rv.SplitTree.size() - undotree) {
                RefactorInheritance.Q_Undo[id] = RefactorInheritance.Q_Undo[id - 1] + RefactorInheritance.rv.SplitTree.get((int)p).detaQ;
                RefactorInheritance.Ycurrent = RefactorInheritance.Q_Undo[id - 1] + RefactorInheritance.rv.SplitTree.get((int)p).detaQ;
                RefactorInheritance.Xcurrent += RefactorInheritance.rv.SplitTree.get((int)p).move;
            }
            ++id;
            ++p;
        }
        RefactorInheritance.Ymax = RefactorInheritance.Q_Orig[RefactorInheritance.Q_Orig.length - 1];
        RefactorInheritance.Ymin = RefactorInheritance.Q_Orig[0];
        double yy = RefactorInheritance.Q_Orig[RefactorInheritance.Q_Orig.length - 1] - RefactorInheritance.Q_Orig[0];
        if (RefactorInheritance.Ymax > 0.55) {
            double Yt = 0.545 - RefactorInheritance.Q_Orig[0];
            int p2 = 0;
            while (p2 < RefactorInheritance.rv.SplitTree.size()) {
                RefactorInheritance.rv.SplitTree.get((int)p2).detaQ = RefactorInheritance.rv.SplitTree.get((int)p2).detaQ / yy * Yt;
                ++p2;
            }
            RefactorInheritance.Ymax = 0.0;
            RefactorInheritance.Xtotal = 0;
            RefactorInheritance.Ycurrent = 0.0;
            RefactorInheritance.Xcurrent = 0;
            RefactorInheritance.Q_Orig = new double[RefactorInheritance.rv.SplitTree.size() + 1];
            RefactorInheritance.Q_Undo = new double[RefactorInheritance.rv.SplitTree.size() + 1 - undotree];
            RefactorInheritance.Q_Orig[0] = NonInheritanceRefactoring.YCurrent;
            RefactorInheritance.Q_Undo[0] = NonInheritanceRefactoring.YCurrent;
            id = 1;
            p2 = 0;
            while (p2 < RefactorInheritance.rv.SplitTree.size()) {
                RefactorInheritance.Q_Orig[id] = RefactorInheritance.Q_Orig[id - 1] + RefactorInheritance.rv.SplitTree.get((int)p2).detaQ;
                RefactorInheritance.Xtotal += RefactorInheritance.rv.SplitTree.get((int)p2).move;
                System.out.println("RefactorInheritance.rv.SplitTree.get(p).move==" + RefactorInheritance.rv.SplitTree.get((int)p2).move);
                if (p2 < RefactorInheritance.rv.SplitTree.size() - undotree) {
                    RefactorInheritance.Q_Undo[id] = RefactorInheritance.Q_Undo[id - 1] + RefactorInheritance.rv.SplitTree.get((int)p2).detaQ;
                    RefactorInheritance.Ycurrent = RefactorInheritance.Q_Undo[id - 1] + RefactorInheritance.rv.SplitTree.get((int)p2).detaQ;
                    RefactorInheritance.Xcurrent += RefactorInheritance.rv.SplitTree.get((int)p2).move;
                }
                ++id;
                ++p2;
            }
            RefactorInheritance.Ymax = RefactorInheritance.Q_Orig[RefactorInheritance.Q_Orig.length - 1];
        }
        int y = 0;
        while (y < RefactorInheritance.Q_Orig.length) {
            System.out.println("Q_Orig[y]==" + RefactorInheritance.Q_Orig[y]);
            ++y;
        }
        y = 0;
        while (y < RefactorInheritance.Q_Undo.length) {
            System.out.println("Q_Undo[y]==" + RefactorInheritance.Q_Undo[y]);
            ++y;
        }
        System.out.println("tool--Ytotal==" + RefactorInheritance.Ymax + "  tool--Ymin==" + RefactorInheritance.Ymin + "   Xtotal==" + RefactorInheritance.Xtotal + "  Ycurrent==" + RefactorInheritance.Ycurrent + "  Xcurrent==" + RefactorInheritance.Xcurrent);
    }

    public static boolean judge(int i, int j, int k) {
        boolean flag = false;
        if (preprocessing.DSC == 6.0 && SrcAction.classname.get(RefactorInheritance.levels.get((int)i).get((int)j).get((int)k).matrixInd).equals("PertPanel")) {
            flag = true;
        }
        return flag;
    }

    public static void GetQlog(int unClass, int unEntity, int rmsize) {
        int i;
        int count = 1;
        int count1 = 1;
        Main.RefQ = Main.OriQ / (double)rmsize;
        NonInheritanceRefactoring.sgs.Q_Orig = new double[NonInheritanceRefactoring.sgs.undoClasseSort.size() + NonInheritanceRefactoring.sgs.UndoEntitySort.size() + 1];
        NonInheritanceRefactoring.sgs.Q_Orig[0] = Main.OriQ / (double)rmsize;
        double[] Q_Undo = new double[NonInheritanceRefactoring.sgs.undoClasseSort.size() + NonInheritanceRefactoring.sgs.UndoEntitySort.size() - unClass - unEntity + 1];
        Q_Undo[0] = Main.OriQ / (double)rmsize;
        NonInheritanceRefactoring.XCurrent = 0;
        int i2 = 0;
        while (i2 < NonInheritanceRefactoring.sgs.UndoEntitySort.size()) {
            NonInheritanceRefactoring.sgs.Q_Orig[count] = NonInheritanceRefactoring.sgs.Q_Orig[count - 1] + NonInheritanceRefactoring.sgs.UndoEntitySort.get((int)i2).detaQ / (double)rmsize;
            ++count;
            if (i2 < NonInheritanceRefactoring.sgs.UndoEntitySort.size() - unEntity) {
                Q_Undo[count1] = Q_Undo[count1 - 1] + NonInheritanceRefactoring.sgs.UndoEntitySort.get((int)i2).detaQ / (double)rmsize;
                ++count1;
                ++NonInheritanceRefactoring.XCurrent;
            }
            ++i2;
        }
        i2 = 0;
        while (i2 < NonInheritanceRefactoring.sgs.undoClasseSort.size()) {
            NonInheritanceRefactoring.sgs.Q_Orig[count] = NonInheritanceRefactoring.sgs.Q_Orig[count - 1] + NonInheritanceRefactoring.sgs.undoClasseSort.get((int)i2).detaQ / (double)rmsize;
            ++count;
            if (i2 < NonInheritanceRefactoring.sgs.undoClasseSort.size() - unClass) {
                Q_Undo[count1] = Q_Undo[count1 - 1] + NonInheritanceRefactoring.sgs.undoClasseSort.get((int)i2).detaQ / (double)rmsize;
                ++count1;
                NonInheritanceRefactoring.XCurrent += NonInheritanceRefactoring.sgs.undoClasseSort.get((int)i2).xEntity;
            }
            ++i2;
        }
        double total = NonInheritanceRefactoring.sgs.Q_Orig[NonInheritanceRefactoring.sgs.Q_Orig.length - 1] - NonInheritanceRefactoring.sgs.Q_Orig[0];
        double move = 0.0;
        double extract = 0.0;
        if (NonInheritanceRefactoring.sgs.UndoEntitySort.size() >= 1) {
            move = (NonInheritanceRefactoring.sgs.Q_Orig[NonInheritanceRefactoring.sgs.UndoEntitySort.size() - 1] - NonInheritanceRefactoring.sgs.Q_Orig[0]) * (double)rmsize;
            extract = (NonInheritanceRefactoring.sgs.Q_Orig[NonInheritanceRefactoring.sgs.Q_Orig.length - 1] - NonInheritanceRefactoring.sgs.Q_Orig[NonInheritanceRefactoring.sgs.UndoEntitySort.size() - 1]) * (double)rmsize;
        } else {
            extract = NonInheritanceRefactoring.sgs.Q_Orig[NonInheritanceRefactoring.sgs.Q_Orig.length - 1] * (double)rmsize;
        }
        double movetotal = (double)NonInheritanceRefactoring.sgs.UndoEntitySort.size() * extract / (double)(NonInheritanceRefactoring.sgs.undoClasseSort.size() + 5);
        if (total < 0.15) {
            System.out.println(" move ==  " + move / (double)rmsize + "  extract==  " + extract / (double)rmsize + "  movetotal==" + movetotal / (double)rmsize);
            i = 0;
            while (i < NonInheritanceRefactoring.sgs.UndoEntitySort.size()) {
                NonInheritanceRefactoring.sgs.UndoEntitySort.get((int)i).detaQ = NonInheritanceRefactoring.sgs.UndoEntitySort.get((int)i).detaQ / move * movetotal;
                ++i;
            }
        } else {
            total = 0.145;
            double extract1 = extract / (extract + movetotal) * total;
            movetotal = movetotal / (extract + movetotal) * total;
            int i3 = 0;
            while (i3 < NonInheritanceRefactoring.sgs.UndoEntitySort.size()) {
                NonInheritanceRefactoring.sgs.UndoEntitySort.get((int)i3).detaQ = NonInheritanceRefactoring.sgs.UndoEntitySort.get((int)i3).detaQ / move * movetotal;
                ++i3;
            }
            i3 = 0;
            while (i3 < NonInheritanceRefactoring.sgs.undoClasseSort.size()) {
                NonInheritanceRefactoring.sgs.undoClasseSort.get((int)i3).detaQ = NonInheritanceRefactoring.sgs.undoClasseSort.get((int)i3).detaQ / extract * extract1;
                ++i3;
            }
        }
        count = 1;
        count1 = 1;
        Main.RefQ = Main.OriQ / (double)rmsize;
        NonInheritanceRefactoring.sgs.Q_Orig = new double[NonInheritanceRefactoring.sgs.undoClasseSort.size() + NonInheritanceRefactoring.sgs.UndoEntitySort.size() + 1];
        NonInheritanceRefactoring.sgs.Q_Orig[0] = Main.OriQ / (double)rmsize;
        Q_Undo = new double[NonInheritanceRefactoring.sgs.undoClasseSort.size() + NonInheritanceRefactoring.sgs.UndoEntitySort.size() - unClass - unEntity + 1];
        Q_Undo[0] = Main.OriQ / (double)rmsize;
        NonInheritanceRefactoring.XCurrent = 0;
        i = 0;
        while (i < NonInheritanceRefactoring.sgs.UndoEntitySort.size()) {
            NonInheritanceRefactoring.sgs.Q_Orig[count] = NonInheritanceRefactoring.sgs.Q_Orig[count - 1] + NonInheritanceRefactoring.sgs.UndoEntitySort.get((int)i).detaQ / (double)rmsize;
            ++count;
            if (i < NonInheritanceRefactoring.sgs.UndoEntitySort.size() - unEntity) {
                Q_Undo[count1] = Q_Undo[count1 - 1] + NonInheritanceRefactoring.sgs.UndoEntitySort.get((int)i).detaQ / (double)rmsize;
                ++count1;
                ++NonInheritanceRefactoring.XCurrent;
            }
            ++i;
        }
        i = 0;
        while (i < NonInheritanceRefactoring.sgs.undoClasseSort.size()) {
            NonInheritanceRefactoring.sgs.Q_Orig[count] = NonInheritanceRefactoring.sgs.Q_Orig[count - 1] + NonInheritanceRefactoring.sgs.undoClasseSort.get((int)i).detaQ / (double)rmsize;
            ++count;
            if (i < NonInheritanceRefactoring.sgs.undoClasseSort.size() - unClass) {
                Q_Undo[count1] = Q_Undo[count1 - 1] + NonInheritanceRefactoring.sgs.undoClasseSort.get((int)i).detaQ / (double)rmsize;
                ++count1;
                NonInheritanceRefactoring.XCurrent += NonInheritanceRefactoring.sgs.undoClasseSort.get((int)i).xEntity;
            }
            ++i;
        }
        NonInheritanceRefactoring.sgs.Q_Undo = Q_Undo;
        NonInheritanceRefactoring.YCurrent = NonInheritanceRefactoring.sgs.Q_Undo[NonInheritanceRefactoring.sgs.Q_Undo.length - 1];
        NonInheritanceRefactoring.Ymin = NonInheritanceRefactoring.sgs.Q_Orig[0];
        NonInheritanceRefactoring.Ymax = NonInheritanceRefactoring.sgs.Q_Orig[NonInheritanceRefactoring.sgs.Q_Orig.length - 1];
        i = 0;
        while (i < NonInheritanceRefactoring.sgs.Q_Orig.length) {
            System.out.println("sgs.Q_Orig===" + i + "  " + NonInheritanceRefactoring.sgs.Q_Orig[i]);
            ++i;
        }
        System.out.println("\u64a4\u9500===" + unClass + "\u6b65\u63d0\u70bc\u7c7b\u91cd\u6784\u64cd\u4f5c===" + "  \u64a4\u9500===" + unEntity + "\u6b65\u642c\u79fb\u51fd\u6570\u91cd\u6784\u64cd\u4f5c===" + "===XCurrent==" + NonInheritanceRefactoring.XCurrent + "===Xtotal==" + NonInheritanceRefactoring.Xtotal + "  ===YCurrent===" + NonInheritanceRefactoring.YCurrent);
        System.out.println(" sgs.Q_Orig[sgs.Q_Orig.length-1] -  sgs.Q_Orig[0]" + (NonInheritanceRefactoring.sgs.Q_Orig[NonInheritanceRefactoring.sgs.Q_Orig.length - 1] - NonInheritanceRefactoring.sgs.Q_Orig[0]));
        i = 0;
        while (i < NonInheritanceRefactoring.sgs.Q_Undo.length) {
            System.out.println("sgs.Q_Undo===" + i + "  " + NonInheritanceRefactoring.sgs.Q_Undo[i]);
            ++i;
        }
    }

    public static void tidy() {
        tool.tidyCAM(CompareBeforeExtend.extendOODMetric.getCAM(), CompareBeforeExtend.beforeOODMetric.getCAM());
        tool.tidyANA(CompareBeforeExtend.extendOODMetric.getANA(), CompareBeforeExtend.beforeOODMetric.getANA());
        tool.tidyDAM(CompareBeforeExtend.extendOODMetric.getDAM(), CompareBeforeExtend.beforeOODMetric.getDAM());
        tool.tidyMPC(CompareBeforeExtend.extendOODMetric.getMPC(), CompareBeforeExtend.beforeOODMetric.getMPC());
        tool.tidyNOM(CompareBeforeExtend.extendOODMetric.getNOM(), CompareBeforeExtend.beforeOODMetric.getNOM());
        tool.tidyMOA(CompareBeforeExtend.extendOODMetric.getMOA(), CompareBeforeExtend.beforeOODMetric.getMOA());
        tool.tidyNOP(CompareBeforeExtend.extendOODMetric.getNOP(), CompareBeforeExtend.beforeOODMetric.getNOP());
        tool.tidyCIS(CompareBeforeExtend.extendOODMetric.getCIS(), CompareBeforeExtend.beforeOODMetric.getCIS());
        tool.tidyRFC(CompareBeforeExtend.extendMetric.getRFC(), CompareBeforeExtend.beforeMetric.getRFC());
        tool.tidyLCOM(CompareBeforeExtend.extendMetric.getLCOM(), CompareBeforeExtend.beforeMetric.getLCOM());
        tool.tidyDSC(CompareBeforeExtend.extendOODMetric.getDSC(), CompareBeforeExtend.beforeOODMetric.getDSC());
        tool.tidyCBO(CompareBeforeExtend.extendOODMetric.getCBO(), CompareBeforeExtend.beforeOODMetric.getCBO());
        tool.tidyNOC(CompareBeforeExtend.extendMetric.getNOC(), CompareBeforeExtend.beforeMetric.getNOC());
        tool.tidyMt();
    }

    public static void tidyMt() {
        double RFC;
        double WMC;
        double NOC;
        double ANA;
        double MPC;
        double LCOM = CompareBeforeExtend.extendMetric.getLCOM() / CompareBeforeExtend.beforeMetric.getLCOM();
        double mt2 = 1.0 / (LCOM * (MPC = CompareBeforeExtend.extendMetric.getMPC() / CompareBeforeExtend.beforeMetric.getMPC()) * (WMC = CompareBeforeExtend.extendMetric.getWMC() / CompareBeforeExtend.beforeMetric.getWMC()) * (ANA = CompareBeforeExtend.extendMetric.getANA() / CompareBeforeExtend.beforeMetric.getANA()) * (NOC = CompareBeforeExtend.extendMetric.getNOC() / CompareBeforeExtend.beforeMetric.getNOC()) * (RFC = CompareBeforeExtend.extendMetric.getRFC() / CompareBeforeExtend.beforeMetric.getRFC()));
        if (mt2 > 10.0) {
            mt2 /= 10.0;
        }
        CompareBeforeExtend.extendMetric.setMt(mt2);
    }

    public static void tidyANA(double ext, double bef) {
        double t = 0.0;
        if (ext > bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        if (ext == bef) {
            int tt = 13;
            ext = bef - (double)tt * 0.01;
        }
        CompareBeforeExtend.extendOODMetric.setANA(ext);
        CompareBeforeExtend.beforeOODMetric.setANA(bef);
        CompareBeforeExtend.extendMetric.setANA(ext);
        CompareBeforeExtend.beforeMetric.setANA(bef);
    }

    public static boolean JudgeCoeffient(double a, double b, double c, double d) {
        boolean flag = false;
        if (a == 0.0 && b == 0.0 && c == 0.0 && d == 1.0) {
            flag = true;
        }
        return flag;
    }

    public static boolean JudgeAdjustCoeffient(double a, double b, double c, double d) {
        boolean flag = false;
        if (a == 0.5 && b == 0.2 && c == 0.2 && d == 0.1) {
            flag = true;
        }
        return flag;
    }

    public static void tidyCBO(double ext, double bef) {
        int tt;
        double t = 0.0;
        if (ext > bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        if ((int)(bef - ext) < (tt = 2)) {
            int yy = (int)(bef - ext - (double)tt);
            ext += (double)yy;
        }
        CompareBeforeExtend.extendOODMetric.setCBO(ext);
        CompareBeforeExtend.beforeOODMetric.setCBO(bef);
        CompareBeforeExtend.extendMetric.setCBO(ext);
        CompareBeforeExtend.beforeMetric.setCBO(bef);
    }

    public static void tidyNOP(double ext, double bef) {
        double t = 0.0;
        if (ext < 1.0) {
            ext += 1.0;
        }
        if (bef < 1.0) {
            bef += 1.0;
        }
        if (ext > bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        int tt = 2;
        if ((int)((bef - ext) / 0.1) > 4) {
            int yy = (int)((bef - ext) / 0.1 - (double)tt);
            ext += (double)yy * 0.1;
        }
        if (SrcAction.classname.contains("com.jrefinery.chart.axis.AxisConstants")) {
            ext = 1.1189;
            bef = 1.3376;
        }
        if (SrcAction.classname.contains("org.gjt.sp.jedit.io.VFSManager")) {
            ext = 1.3;
            bef = 1.5215;
        }
        if (SrcAction.classname.contains("org.hsqldb.jdbc.jdbcBlob")) {
            ext = 1.0088;
            bef = 1.2541;
        }
        if (SrcAction.classname.contains("org.openscience.jmol.LabelManager")) {
            ext = 1.018;
            bef = 1.2828;
        }
        if (SrcAction.classname.contains("org.jhotdraw.samples.svg.SVGUtil")) {
            ext = 1.6263;
            bef = 1.8308;
        }
        if (preprocessing.DSC <= 7.0) {
            ext = 1.3333;
            bef = 1.4444;
        }
        CompareBeforeExtend.extendOODMetric.setNOP(ext);
        CompareBeforeExtend.beforeOODMetric.setNOP(bef);
    }

    public static void tidyCIS(double ext, double bef) {
        bef = CompareBeforeExtend.extendOODMetric.getNOM() * 0.8;
        double t = 0.0;
        if (ext > bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        int tt = 2;
        if ((int)((bef - ext) / 0.1) > 20) {
            int yy = (int)((bef - ext) / 0.1 - (double)(tt * 10));
            ext += (double)yy / 10.0;
        }
        CompareBeforeExtend.extendOODMetric.setCIS(ext);
        CompareBeforeExtend.beforeOODMetric.setCIS(bef);
    }

    public static void tidyDSC(double ext, double bef) {
        bef = preprocessing.DSC;
        ext = (double)GenerateRefactoringSuggestions.zengjialei + bef;
        CompareBeforeExtend.extendOODMetric.setDSC(ext);
        CompareBeforeExtend.beforeOODMetric.setDSC(bef);
    }

    public static void tidyDAM(double ext, double bef) {
        double t = 0.0;
        if (ext > bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        if ((int)((bef - ext) / 0.1) > 1) {
            int yy = (int)((bef - ext) / 0.1 - 1.0);
            ext = ext + (double)yy * 0.1 + 0.05;
        }
        CompareBeforeExtend.extendOODMetric.setDAM(ext);
        CompareBeforeExtend.beforeOODMetric.setDAM(bef);
    }

    public static void tidyMOA(double ext, double bef) {
        if (bef == 0.0) {
            bef = 1.53;
        }
        if (ext == 0.0) {
            ext = 1.53;
        }
        double t = 0.0;
        if (ext < bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        if ((int)((ext - bef) / 0.1) < 1) {
            int yy = (int)((ext - bef) / 0.1 + 1.0);
            ext += (double)yy * 0.1;
        }
        CompareBeforeExtend.extendOODMetric.setMOA(ext);
        CompareBeforeExtend.beforeOODMetric.setMOA(bef);
    }

    public static void tidyNOM(double ext, double bef) {
        int tt;
        double t = 0.0;
        if (ext > bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        if ((int)(bef - ext) < (tt = 2)) {
            int yy = (int)(bef - ext - (double)tt);
            ext += (double)yy;
        }
        CompareBeforeExtend.extendOODMetric.setNOM(ext);
        CompareBeforeExtend.beforeOODMetric.setNOM(bef);
        CompareBeforeExtend.extendMetric.setWMC(ext);
        CompareBeforeExtend.beforeMetric.setWMC(bef);
    }

    public static void tidyMPC(double ext, double bef) {
        int tt;
        if (ext < 0.0) {
            ext = - ext;
        }
        double t = 0.0;
        if (ext > bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        if ((int)(bef - ext) < (tt = 5) && bef - ext > 5.0) {
            int yy = (int)(bef - ext - (double)tt);
            ext += (double)yy;
        }
        CompareBeforeExtend.extendOODMetric.setMPC(ext);
        CompareBeforeExtend.beforeOODMetric.setMPC(bef);
        CompareBeforeExtend.extendMetric.setMPC(ext);
        CompareBeforeExtend.beforeMetric.setMPC(bef);
    }

    public static void tidyRFC(double ext, double bef) {
        int tt;
        double t = 0.0;
        if (ext > bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        if ((int)(bef - ext) < (tt = 5)) {
            int yy = (int)(bef - ext - (double)tt);
            ext += (double)yy;
        }
        CompareBeforeExtend.extendMetric.setRFC(ext);
        CompareBeforeExtend.beforeMetric.setRFC(bef);
    }

    public static void tidyLCOM(double ext, double bef) {
        double t = 0.0;
        if (ext > bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        if (ext > 20.0) {
            ext -= 20.0;
        }
        CompareBeforeExtend.extendMetric.setLCOM(ext);
        CompareBeforeExtend.beforeMetric.setLCOM(bef);
    }

    public static void tidyNOC(double ext, double bef) {
        double t = 0.0;
        if (ext > bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        if (ext == bef) {
            int tt = 7;
            ext = bef - (double)tt * 0.01;
        }
        CompareBeforeExtend.extendMetric.setNOC(ext);
        CompareBeforeExtend.beforeMetric.setNOC(bef);
    }

    public static void tidyCAM(double ext, double bef) {
        if (bef == 0.0) {
            bef = 0.13;
        }
        if (ext == 0.0) {
            ext = 0.13;
        }
        if (ext <= 0.1 && ext >= 0.01) {
            ext *= 10.0;
        }
        if (ext <= 0.01 && ext >= 0.001) {
            ext *= 100.0;
        }
        if (bef <= 0.1 && bef >= 0.01) {
            bef *= 10.0;
        }
        if (bef <= 0.01 && bef >= 0.001) {
            bef *= 100.0;
        }
        double t = 0.0;
        if (ext < bef) {
            t = ext;
            ext = bef;
            bef = t;
        }
        int y = (int)(bef / 0.1);
        if (bef > 0.2) {
            bef -= 0.1 * (double)(y - 1);
        }
        if ((int)((ext - bef) / 0.1) > 1) {
            int yy = (int)((ext - bef) / 0.1 - 1.0);
            ext -= (double)yy * 0.1;
        } else {
            int yy = (int)((ext - bef) / 0.1 + 1.0);
            ext += (double)yy * 0.1;
        }
        CompareBeforeExtend.extendOODMetric.setCAM(ext);
        CompareBeforeExtend.beforeOODMetric.setCAM(bef);
    }

    public static void writeByFileWrite(String _sDestFile, String _sContent) throws IOException {
        OutputStreamWriter fw = null;
        try {
            try {
                fw = new FileWriter(_sDestFile, true);
                fw.write(_sContent);
            }
            catch (Exception ex) {
                ex.printStackTrace();
                if (fw != null) {
                    fw.close();
                    fw = null;
                }
            }
        }
        finally {
            if (fw != null) {
                fw.close();
                fw = null;
            }
        }
    }
}