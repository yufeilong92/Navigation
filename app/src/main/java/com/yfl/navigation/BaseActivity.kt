package com.yfl.navigation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType

 abstract class BaseActivity <T : ViewBinding> : AppCompatActivity() {
    protected lateinit var viewBinding: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  ParameterizedType 表示参数化类型，带有类型参数的类型，即常说的泛型，如：List<T>、Map<Integer, String>、List<? extends Number>。
        val pt = javaClass.genericSuperclass as ParameterizedType

        val cla = pt.actualTypeArguments[0] as Class<*>
        try {
            //通过反射加载类的inflate方法
            val declaredMethod = cla.getDeclaredMethod("inflate", LayoutInflater::class.java)
            //通过调用对应方法并强转成T
            viewBinding = declaredMethod.invoke(null, layoutInflater) as T
            setContentView(viewBinding.root)
            initCreate()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
    }

    abstract fun initCreate()
}