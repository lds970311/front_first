//CREATE AT: 2021-12-13
export default function useCopy(text: string) {
    const input = document.createElement('input')
    input.value = text
    document.body.appendChild(input)
    //选择输入框
    input.select();
    //执行复制操作
    document.execCommand('Copy')
    document.body.removeChild(input)
}
