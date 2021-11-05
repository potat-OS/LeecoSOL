/* void CalculatePorosity(double coefficient[], double depthStart, double depthEnd, SCurveTrace *por)
{
    this.SetLoopRange(depthStart, depthEnd); //设置循环的起止深度范围
    // 循环，根据公式计算并将值赋给图道
    do
    {
        if (this.GR.Value < 80)
        {
            por.Value = coefficient[2] + coefficient[0] * this.DEN.Value + coefficient[1] * this.VSH.Value;
        }
        else
        {
            por.Value = 0.001;
        }
    } while (this.NextRow());
}

void main()
{
    // 新建曲线道，命名为POR
    SCurveTrace por = this.Channels.AddTrace(WellTraceTypes.Curve, "POR");
    // 定义道头显示内容
    por.Title = "计算孔隙度";
    // 定义深度
    double depth[4] = {4955.04, 5010, 5130, 5230};
    // 定义DEN, VSH系数项及常数
    double coefficient[3][3] = {{-32.38, -0.41, 94.70}, {-31.03, -0.17, 88.79}, {-34.27, -0.26, 98.11}};
    for (int i = 0; i < 3; i++)
    {
        CalculatePorosity(coefficient[i], depth[i], depth[i + 1], por);
    }
} */