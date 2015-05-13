package com.yayun.gitlearning;



import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import android.webkit.URLUtil;


/**
* �汾��⣬�Զ�����
* 
* @author shenyj-ydrh 1.ͨ��Url������ 2.���ز���װ���� 3.ɾ����ʱ·��
* 
*/
public class UpdateCheck {
        // ���ø��µ�Activity
        public Activity activity = null;
        // ��ǰ�汾��
        public int versionCode = 0;
        // ��ǰ�汾����
        public String versionName = "";
        // ����̨��Ϣ��ʶ
        private static final String TAG = "AutoUpdate";
        // �ļ���ǰ·��
        private String currentFilePath = "";
        // ��װ���ļ���ʱ·��
        private String currentTempFilePath = "";
        // ����ļ���չ���ַ���
        private String fileEx = "";
        // ����ļ����ַ���
        private String fileNa = "";
        // ��������ַ
        private String strURL = "http://127.0.0.1:8080/ApiDemos.apk";
        private ProgressDialog dialog;

        /**
         * ���췽������õ�ǰ�汾��Ϣ
         * 
         * @param activity
         */
        public UpdateCheck(Activity activity) {
                this.activity = activity;
                // ��õ�ǰ�汾
                getCurrentVersion();
        }

        /**
         * ������
         */
        public void check() {
                // �������
                if (isNetworkAvailable(this.activity) == false) {
                        return;
                }
                // ���������ã���⵽�°汾
                if (true) {
                        // �����Ի���ѡ���Ƿ���Ҫ���°汾
                        showUpdateDialog();
                }
        }

        /**
         * ����Ƿ��п�������
         * 
         * @param context
         * @return ��������״̬
         */
        public static boolean isNetworkAvailable(Context context) {
                try {
                        ConnectivityManager cm = (ConnectivityManager) context
                                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                        // ��ȡ������Ϣ
                        NetworkInfo info = cm.getActiveNetworkInfo();
                        // ���ؼ�������״̬
                        return (info != null && info.isConnected());
                } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                }
        }

        /**
         * �����Ի���ѡ���Ƿ���Ҫ���°汾
         */
        public void showUpdateDialog() {
                @SuppressWarnings("unused")
                AlertDialog alert = new AlertDialog.Builder(this.activity)
                                .setTitle("�°汾").setIcon(R.drawable.ic_launcher)
                                .setMessage("�Ƿ���£�")
                                .setPositiveButton("��", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                                // ͨ����ַ�����ļ�
                                                downloadTheFile(strURL);
                                                // ��ʾ����״̬��������
                                                showWaitDialog();
                                        }
                                })
                                .setNegativeButton("��", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                        }
                                }).show();
        }

        /**
         * ��ʾ����״̬��������
         */
        public void showWaitDialog() {
                dialog = new ProgressDialog(activity);
                dialog.setMessage("���ڸ��£����Ժ�...");
                dialog.setIndeterminate(true);
                dialog.setCancelable(true);
                dialog.show();
        }

        /**
         * ��õ�ǰ�汾��Ϣ
         */
        public void getCurrentVersion() {
                try {
                        // ��ȡӦ�ð���Ϣ
                        PackageInfo info = activity.getPackageManager().getPackageInfo(
                                        activity.getPackageName(), 0);
                        this.versionCode = info.versionCode;
                        this.versionName = info.versionName;
                } catch (NameNotFoundException e) {
                        e.printStackTrace();
                }
        }

        /**
         * ��ȡ�ļ����Ʋ�ִ������
         * 
         * @param strPath
         */
        private void downloadTheFile(final String strPath) {
                // ����ļ��ļ���չ���ַ���
                fileEx = strURL.substring(strURL.lastIndexOf(".") + 1, strURL.length())
                                .toLowerCase();
                // ����ļ��ļ����ַ���
                fileNa = strURL.substring(strURL.lastIndexOf("/") + 1,
                                strURL.lastIndexOf("."));
                try {
                        if (strPath.equals(currentFilePath)) {
                                doDownloadTheFile(strPath);
                        }
                        currentFilePath = strPath;
                        new Thread(new Runnable() {

                                @Override
                                public void run() {
                                        // TODO Auto-generated method stub
                                        try {
                                                // ִ������
                                                doDownloadTheFile(strPath);
                                        } catch (Exception e) {
                                                Log.e(TAG, e.getMessage(), e);
                                        }
                                }
                        }).start();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        /**
         * ִ���°汾�������أ�����װ
         * 
         * @param strPath
         * @throws Exception
         */
        private void doDownloadTheFile(String strPath) throws Exception {
                Log.i(TAG, "getDataSource()");
                // �ж�strPath�Ƿ�Ϊ�����ַ
                if (!URLUtil.isNetworkUrl(strPath)) {
                        Log.i(TAG, "��������ַ����");
                } else {
                        URL myURL = new URL(strPath);
                        URLConnection conn = myURL.openConnection();
                        conn.connect();
                        InputStream is = conn.getInputStream();
                        if (is == null) {
                                throw new RuntimeException("stream is null");
                        }
                        //����һ����ʱ�ļ� 
                        File myTempFile = File.createTempFile(fileNa, "." + fileEx);
                        // ��װ���ļ���ʱ·��
                        currentTempFilePath = myTempFile.getAbsolutePath();
                        FileOutputStream fos = new FileOutputStream(myTempFile);
                        byte buf[] = new byte[128];
                        do {
                                int numread = is.read(buf);
                                if (numread <= 0) {
                                        break;
                                }
                                fos.write(buf, 0, numread);
                        } while (true);
                        Log.i(TAG, "getDataSource() Download  ok...");
                        dialog.cancel();
                        dialog.dismiss();
                        // ���ļ�
                        openFile(myTempFile);
                        try {
                                is.close();
                        } catch (Exception ex) {
                                Log.e(TAG, "getDataSource() error: " + ex.getMessage(), ex);
                        }
                }
        }

        /**
         * ���ļ����а�װ
         * 
         * @param f
         */
        private void openFile(File f) {
                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setAction(android.content.Intent.ACTION_VIEW);
                // ������غõ��ļ�����
                String type = getMIMEType(f);
                // �򿪸��������ļ�
                intent.setDataAndType(Uri.fromFile(f), type);
                // ��װ
                activity.startActivity(intent);
        }

        /**
         * ɾ����ʱ·����İ�װ��
         */
        public void delFile() {
                Log.i(TAG, "The TempFile(" + currentTempFilePath + ") was deleted.");
                File myFile = new File(currentTempFilePath);
                if (myFile.exists()) {
                        myFile.delete();
                }
        }

        /**
         * ��������ļ�������
         * 
         * @param f
         *            �ļ�����
         * @return �ļ�����
         */
        private String getMIMEType(File f) {
                String type = "";
                // ����ļ�����
                String fName = f.getName();
                // ����ļ���չ��
                String end = fName
                                .substring(fName.lastIndexOf(".") + 1, fName.length())
                                .toLowerCase();
                if (end.equals("m4a") || end.equals("mp3") || end.equals("mid")
                                || end.equals("xmf") || end.equals("ogg") || end.equals("wav")) {
                        type = "audio";
                } else if (end.equals("3gp") || end.equals("mp4")) {
                        type = "video";
                } else if (end.equals("jpg") || end.equals("gif") || end.equals("png")
                                || end.equals("jpeg") || end.equals("bmp")) {
                        type = "image";
                } else if (end.equals("apk")) {
                        type = "application/vnd.android.package-archive";
                } else {
                        type = "*";
                }
                if (end.equals("apk")) {
                } else {
                        type += "/*";
                }
                return type;
        }
}