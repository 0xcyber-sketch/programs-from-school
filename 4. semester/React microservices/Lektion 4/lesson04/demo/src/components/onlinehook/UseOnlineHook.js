import useOnline from "./useOnline";

function UseOnlineHook() {
    const onLine = useOnline()

    if (!onLine) {
        return (
            <h1>We went offline</h1>
        )
    }

    return (
        <>
            <h1>We went online</h1>
        </>
    )
}
export default UseOnlineHook